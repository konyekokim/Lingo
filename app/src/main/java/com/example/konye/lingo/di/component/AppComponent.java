package com.example.konye.lingo.di.component;


import android.content.Context;

import com.example.konye.lingo.Mahadum;
import com.example.konye.lingo.data.ApiService;
import com.example.konye.lingo.data.RealmService;
import com.example.konye.lingo.di.module.AppModule;
import com.example.konye.lingo.di.module.RealmModule;
import com.example.konye.lingo.di.module.SchedulerProviderModule;
import com.example.konye.lingo.di.qaulifier.AppContext;
import com.example.konye.lingo.di.scope.AppScope;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, SchedulerProviderModule.class, RealmModule.class})
public interface AppComponent {

    ApiService getApiService();
    RealmService getRealmService();

    @AppContext
    Context getContext();

    void inject(Mahadum application);
}
