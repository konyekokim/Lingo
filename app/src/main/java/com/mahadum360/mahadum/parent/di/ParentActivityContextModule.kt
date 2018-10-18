package com.mahadum360.mahadum.parent.di

import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.parent.ParentContract
import com.mahadum360.mahadum.parent.ParentPresenter
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class ParentActivityContextModule(private val view: ParentContract.View){

    @Provides
    @ParentScope
    internal fun providesView(): ParentContract.View{
        return view
    }

    @Provides
    @ParentScope
    internal fun providesPresenter(apiService: ApiService, realmService: RealmService, view: ParentContract.View,
                                   provider: SchedulerProvider): ParentPresenter{
        return ParentPresenter(apiService, realmService, view, provider)
    }
}