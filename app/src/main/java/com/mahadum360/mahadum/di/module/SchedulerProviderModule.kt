package com.mahadum360.mahadum.di.module


import com.mahadum360.mahadum.utils.schedule.BaseScheduler
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class SchedulerProviderModule {

    @Provides
    @Singleton
    fun provideScheduler(): BaseScheduler {
        return SchedulerProvider.instance
    }

    @Provides
    @Singleton
    fun scheduler(): SchedulerProvider {
        return SchedulerProvider.instance
    }
}
