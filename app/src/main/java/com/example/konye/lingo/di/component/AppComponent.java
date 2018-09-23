package com.example.konye.lingo.di.component;

import com.example.konye.lingo.di.module.AppModule;
import com.example.konye.lingo.di.module.RealmModule;
import com.example.konye.lingo.di.module.SchedulerProviderModule;
import com.example.konye.lingo.ui.activities.auth.di.AuthActivityComponent;
import com.example.konye.lingo.ui.activities.auth.di.AuthActivityContextModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, SchedulerProviderModule.class, RealmModule.class})
public interface AppComponent {
    /*
    void inject(Mahadum application);*/

    AuthActivityComponent add(AuthActivityContextModule module);
}
