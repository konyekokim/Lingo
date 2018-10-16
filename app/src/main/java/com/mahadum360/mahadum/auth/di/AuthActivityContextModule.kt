package com.mahadum360.mahadum.auth.di

import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.auth.AuthContract
import com.mahadum360.mahadum.auth.AuthPresenter
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class AuthActivityContextModule(private val view: AuthContract.View) {

    @Provides
    @AuthScope
    internal fun providesView(): AuthContract.View {
        return view
    }

    @Provides
    @AuthScope
    internal fun providesPresenter(apiService: ApiService, realmService: RealmService, view: AuthContract.View,
                                   provider: SchedulerProvider): AuthPresenter {
        return AuthPresenter(apiService, realmService, view, provider)
    }
}
