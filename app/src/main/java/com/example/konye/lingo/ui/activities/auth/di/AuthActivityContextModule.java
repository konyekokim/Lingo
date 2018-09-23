package com.example.konye.lingo.ui.activities.auth.di;

import android.content.Context;

import com.example.konye.lingo.data.ApiService;
import com.example.konye.lingo.data.RealmService;
import com.example.konye.lingo.ui.activities.auth.AuthContract;
import com.example.konye.lingo.ui.activities.auth.AuthPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthActivityContextModule {


    private AuthContract.View view;

    public AuthActivityContextModule(AuthContract.View view) {
        this.view = view;
    }

    @Provides
    @AuthScope
    AuthContract.View providesView() {
        return view;
    }

    @Provides
    @AuthScope
    AuthPresenter providesPresenter(ApiService apiService, RealmService realmService, AuthContract.View view) {
        return new AuthPresenter(apiService, realmService, view);
    }
}
