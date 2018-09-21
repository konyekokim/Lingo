package com.example.konye.lingo.ui.activities.login.di;

import com.example.konye.lingo.api.ApiService;
import com.example.konye.lingo.api.PrefManager;
import com.example.konye.lingo.di.scope.ActivityScope;
import com.example.konye.lingo.ui.activities.login.LoginContract;
import com.example.konye.lingo.ui.activities.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityMvpModule {

    private LoginContract.View view;

    public LoginActivityMvpModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    LoginContract.View providesView() {
        return view;
    }

    @Provides
    @ActivityScope
    LoginPresenter providesPresenter(ApiService apiService, LoginContract.View view) {
        return new LoginPresenter(apiService, view);
    }
}
