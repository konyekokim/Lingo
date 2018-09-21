package com.example.konye.lingo.ui.activities.auth.di;

import com.example.konye.lingo.data.ApiService;
import com.example.konye.lingo.data.RealmService;
import com.example.konye.lingo.di.scope.ActivityScope;
import com.example.konye.lingo.ui.activities.auth.AuthContract;
import com.example.konye.lingo.ui.activities.auth.AuthPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthActivityMvpModule {

    private AuthContract.View view;

    public AuthActivityMvpModule(AuthContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    AuthContract.View providesView() {
        return view;
    }

    @Provides
    @ActivityScope
    AuthPresenter providesPresenter(ApiService apiService, RealmService realmService, AuthContract.View view) {
        return new AuthPresenter(apiService, realmService, view);
    }
}
