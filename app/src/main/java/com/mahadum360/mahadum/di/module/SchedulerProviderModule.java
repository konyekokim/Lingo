package com.mahadum360.mahadum.di.module;


import com.mahadum360.mahadum.utils.schedule.BaseScheduler;
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SchedulerProviderModule {

    @Provides
    @Singleton
    public BaseScheduler provideScheduler() {
        return SchedulerProvider.getInstance();
    }

    @Provides
    @Singleton
    public SchedulerProvider scheduler() {
        return SchedulerProvider.getInstance();
    }
}
