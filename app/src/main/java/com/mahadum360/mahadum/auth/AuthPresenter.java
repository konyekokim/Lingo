package com.mahadum360.mahadum.auth;

import android.util.Log;

import com.mahadum360.mahadum.data.ApiService;
import com.mahadum360.mahadum.data.RealmService;
import com.mahadum360.mahadum.models.AuthResponse;
import com.mahadum360.mahadum.models.CreateUser;
import com.mahadum360.mahadum.models.LoginUser;
import com.mahadum360.mahadum.models.User;
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider;

import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class AuthPresenter implements AuthContract.Presenter {

    private ApiService apiService;
    private RealmService realmService;
    private AuthContract.View view;
    private SchedulerProvider provider;
    private CompositeDisposable compositeDisposable;

    @Inject
    public AuthPresenter(ApiService apiService, RealmService realmService, AuthContract.View view,
                         SchedulerProvider provider) {
        this.apiService = apiService;
        this.realmService = realmService;
        this.view = view;
        this.provider = provider;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void logout() {
        //prefManager.logOut();
        view.onLogout();
    }

    @Override
    public void login(LoginUser user) {
        view.showProgress();

        Disposable d = apiService.login(user)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe((r) -> {
                    String token = r.headers().get("MAHADUM-TOKEN");
                    //prefManager.setValue("token", token);
                    AuthResponse result = r.body();
                    realmService.setLoggedIn();
                    view.hideProgress();
                    if (r.isSuccessful()) {
                        view.onLoginSuccess();
                    }
                }, error -> {
                    view.showError("login_error", "An error occurred");
                    Log.e("Login", error.getMessage(), error);
                    view.hideProgress();
                });
        compositeDisposable.add(d);
    }

    @Override
    public void register(CreateUser user) {
        view.showProgress();

        Disposable d = apiService.registerUser(user)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe(item -> {
                    String token = item.headers().get("MAHADUM-TOKEN");
                    //prefManager.setValue("token", token);
                    AuthResponse result = item.body();
                    view.hideProgress();
                    if (item.isSuccessful()) {
                        assert result != null;
                        view.onRegistrationSuccess(authResponseToUser(result, token));
                        realmService.setLoggedIn();
                    }
                }, error -> {
                    view.showError("login_error", "An error occurred");
                    Log.e("Login", error.getMessage(), error);
                    view.hideProgress();
                });
        compositeDisposable.add(d);
    }

    @Override
    public void detachView() {
        compositeDisposable.dispose();
    }

    private User authResponseToUser(AuthResponse response, String token) {
        User user = new User();
        user.setStatus(response.getStatus());
        user.setFirst_name(response.getFirstName());
        user.setSurname(response.getSurname());
        user.setEmail(response.getEmail());
        user.setPhone_number(response.getPhoneNumber());
        user.setType(response.getType());
        user.setAuthToken(token);
        return user;
    }
}
