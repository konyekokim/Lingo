package com.example.konye.lingo.ui.activities.auth;

import android.util.Log;

import com.example.konye.lingo.data.ApiService;
import com.example.konye.lingo.data.RealmService;
import com.example.konye.lingo.models.AuthResponse;
import com.example.konye.lingo.models.CreateUser;
import com.example.konye.lingo.models.LoginUser;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class AuthPresenter implements AuthContract.Presenter {

    private ApiService apiService;
    private RealmService realmService;
    private AuthContract.View view;

    @Inject
    public AuthPresenter(ApiService apiService, RealmService realmService, AuthContract.View view) {
        this.apiService = apiService;
        this.realmService = realmService;
        this.view = view;
    }

    @Override
    public void logout() {
        //prefManager.logOut();
        view.onLogout();
    }

    @Override
    public void login(LoginUser user) {
        view.showProgress();

        apiService.login(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<AuthResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<AuthResponse> response) {
                        String token = response.headers().get("MAHADUM-TOKEN");
                        //prefManager.setValue("token", token);
                        AuthResponse result = response.body();

                        view.hideProgress();
                        if (response.isSuccessful()) {
                            view.onLoginSuccess();
                        } else {
                            view.showError("login", result.getStatus());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError("login_error", "An error occurred");
                        Log.e("Login", e.getMessage(), e);
                        view.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        view.hideProgress();
                        view.showComplete();
                    }
                });
    }

    @Override
    public void register(CreateUser user) {

    }
}
