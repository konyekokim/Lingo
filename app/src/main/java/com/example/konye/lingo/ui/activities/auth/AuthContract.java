package com.example.konye.lingo.ui.activities.auth;

import com.example.konye.lingo.models.CreateUser;
import com.example.konye.lingo.models.LoginUser;

public interface AuthContract {

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

        void register(CreateUser user);
    }
}
