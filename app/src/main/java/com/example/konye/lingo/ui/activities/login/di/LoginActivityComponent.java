package com.example.konye.lingo.ui.activities.login.di;

import android.content.Context;

import com.example.konye.lingo.Mahadum;
import com.example.konye.lingo.di.component.AppComponent;
import com.example.konye.lingo.di.qaulifier.ActivityContext;
import com.example.konye.lingo.di.scope.ActivityScope;
import com.example.konye.lingo.ui.activities.login.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {LoginActivityContextModule.class,
        LoginActivityMvpModule.class},
        dependencies = AppComponent.class)
public interface LoginActivityComponent {

    @ActivityContext
    Context getContext();

    void inject(LoginActivity activity);
}
