package com.mahadum360.mahadum.di.component

import com.mahadum360.mahadum.di.module.AppModule
import com.mahadum360.mahadum.di.module.RealmModule
import com.mahadum360.mahadum.di.module.SchedulerProviderModule
import com.mahadum360.mahadum.auth.di.AuthActivityComponent
import com.mahadum360.mahadum.auth.di.AuthActivityContextModule

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(AppModule::class, SchedulerProviderModule::class, RealmModule::class))
interface AppComponent {
    /*
    void inject(Mahadum application);*/

    fun add(module: AuthActivityContextModule): AuthActivityComponent
}
