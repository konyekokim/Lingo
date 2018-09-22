package com.example.konye.lingo.ui.activities.auth.di;

import android.content.Context;

import com.example.konye.lingo.di.component.AppComponent;
import com.example.konye.lingo.di.qaulifier.ActivityContext;
import com.example.konye.lingo.di.scope.ActivityScope;
import com.example.konye.lingo.ui.activities.auth.AuthActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {AuthActivityContextModule.class,
        AuthActivityMvpModule.class},
        dependencies = AppComponent.class)
public interface AuthActivityComponent {

    @ActivityContext
    Context getContext();

    void inject(AuthActivity activity);
}
