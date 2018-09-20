package com.example.konye.lingo.di.module;

import com.example.konye.lingo.di.scope.ActivityScope;
import com.example.konye.lingo.utils.schedule.BaseScheduler;
import com.example.konye.lingo.utils.schedule.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class SchedulerProviderModule {

    @Provides
    @ActivityScope
    public BaseScheduler provideScheduler() {
        return SchedulerProvider.getInstance();
    }

    @Provides
    @ActivityScope
    public SchedulerProvider scheduler() {
        return SchedulerProvider.getInstance();
    }
}
