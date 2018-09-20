package com.example.konye.lingo.ui.activities.login.di;

import android.content.Context;

import com.example.konye.lingo.di.qaulifier.ActivityContext;
import com.example.konye.lingo.di.scope.ActivityScope;
import com.example.konye.lingo.ui.activities.login.LoginActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityContextModule {

    private LoginActivity activity;
    public Context context;

    public LoginActivityContextModule(LoginActivity activity) {
        this.activity = activity;
        this.context = activity;
    }

    @Provides
    @ActivityScope
    public LoginActivity providesLoginActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }
}
