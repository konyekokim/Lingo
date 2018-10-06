package com.mahadum360.mahadum.auth;


import com.mahadum360.mahadum.models.CreateUser;
import com.mahadum360.mahadum.models.LoginUser;
import com.mahadum360.mahadum.models.User;

public interface AuthContract {

    interface View {
        void hideProgress();

        void showProgress();

        void showComplete();

        void showError(String call, String message);

        void onLoginSuccess();

        void onRegistrationSuccess(User user);

        void onLogout();
    }

    interface Presenter {
        void logout();

        void login(LoginUser user);

        void register(CreateUser user);

        void detachView();
    }
}
