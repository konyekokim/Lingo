package com.example.konye.lingo.ui.activities.login;

import com.example.konye.lingo.models.LoginUser;

public interface LoginContract {

    interface View {
        void hideProgress();

        void showProgress();

        void showComplete();

        void showError(String call, String message);

        void onLoginSuccess();

        void onLogout();
    }

    interface Presenter {
        void logout();

        void login(LoginUser user);
    }
}
