package com.example.konye.lingo.di.module;

import com.example.konye.lingo.utils.schedule.BaseScheduler;
import com.example.konye.lingo.utils.schedule.SchedulerProvider;

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
