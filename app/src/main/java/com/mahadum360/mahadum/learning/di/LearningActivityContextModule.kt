package com.mahadum360.mahadum.learning.di

import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.learning.LearningContract
import com.mahadum360.mahadum.learning.LearningPresenter
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class LearningActivityContextModule(private val view: LearningContract.View){

    @Provides
    @LearningScope
    internal fun providesView(): LearningContract.View{
        return view
    }

    @Provides
    @LearningScope
    internal fun providesPresenter(apiService: ApiService, realmService: RealmService, view: LearningContract.View,
                                   provider: SchedulerProvider): LearningPresenter{
        return LearningPresenter(apiService, realmService, view, provider)
    }
}