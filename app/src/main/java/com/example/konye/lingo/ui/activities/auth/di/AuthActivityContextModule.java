package com.example.konye.lingo.ui.activities.auth.di;

import android.content.Context;

import com.example.konye.lingo.di.qaulifier.ActivityContext;
import com.example.konye.lingo.di.scope.ActivityScope;
import com.example.konye.lingo.ui.activities.auth.AuthActivity;
import com.example.konye.lingo.ui.activities.auth.LoginFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthActivityContextModule {

    private AuthActivity activity;
    public Context context;

    public AuthActivityContextModule(AuthActivity activity) {
        this.activity = activity;
        this.context = activity;
    }

    @Provides
    @ActivityScope
    public AuthActivity providesAuthActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }
}
