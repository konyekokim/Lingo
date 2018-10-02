package com.mahadum360.mahadum.di.component;

import com.mahadum360.mahadum.di.module.AppModule;
import com.mahadum360.mahadum.di.module.RealmModule;
import com.mahadum360.mahadum.di.module.SchedulerProviderModule;
import com.mahadum360.mahadum.ui.activities.auth.di.AuthActivityComponent;
import com.mahadum360.mahadum.ui.activities.auth.di.AuthActivityContextModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, SchedulerProviderModule.class, RealmModule.class})
public interface AppComponent {
    /*
    void inject(Mahadum application);*/

    AuthActivityComponent add(AuthActivityContextModule module);
}
