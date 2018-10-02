package com.mahadum360.mahadum.ui.activities.auth.di;

import com.mahadum360.mahadum.data.ApiService;
import com.mahadum360.mahadum.data.RealmService;
import com.mahadum360.mahadum.ui.activities.auth.AuthContract;
import com.mahadum360.mahadum.ui.activities.auth.AuthPresenter;

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
