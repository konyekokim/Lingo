package com.mahadum360.mahadum.di.component

import com.mahadum360.mahadum.di.module.AppModule
import com.mahadum360.mahadum.di.module.RealmModule
import com.mahadum360.mahadum.di.module.SchedulerProviderModule
import com.mahadum360.mahadum.auth.di.AuthActivityComponent
import com.mahadum360.mahadum.auth.di.AuthActivityContextModule
import com.mahadum360.mahadum.bookstore.di.BookStoreActivityComponent
import com.mahadum360.mahadum.bookstore.di.BookStoreActivityContextModule
import com.mahadum360.mahadum.learning.di.LearningActivityComponent
import com.mahadum360.mahadum.learning.di.LearningActivityContextModule
import com.mahadum360.mahadum.parent.di.ParentActivityComponent
import com.mahadum360.mahadum.parent.di.ParentActivityContextModule

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [AppModule::class, SchedulerProviderModule::class, RealmModule::class])
interface AppComponent {
    /*
    void inject(Mahadum application);*/

    fun add(module: AuthActivityContextModule): AuthActivityComponent

    fun add(module: ParentActivityContextModule): ParentActivityComponent

    fun add(module: BookStoreActivityContextModule): BookStoreActivityComponent

    fun add(module: LearningActivityContextModule): LearningActivityComponent
}
