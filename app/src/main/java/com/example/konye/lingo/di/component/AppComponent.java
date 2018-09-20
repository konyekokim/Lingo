package com.example.konye.lingo.di.component;


import android.content.Context;

import com.example.konye.lingo.Mahadum;
import com.example.konye.lingo.di.module.AppModule;
import com.example.konye.lingo.di.module.SchedulerProviderModule;
import com.example.konye.lingo.di.qaulifier.AppContext;
import com.example.konye.lingo.di.scope.AppScope;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, SchedulerProviderModule.class})
public interface AppComponent {

    @AppContext
    Context getContext();

    void inject(Mahadum application);
}
