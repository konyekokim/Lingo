package com.example.konye.lingo.ui.activities.login.di;

import com.example.konye.lingo.data.ApiService;
import com.example.konye.lingo.data.RealmService;
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
    LoginPresenter providesPresenter(ApiService apiService, RealmService realmService, LoginContract.View view) {
        return new LoginPresenter(apiService, realmService, view);
    }
}
