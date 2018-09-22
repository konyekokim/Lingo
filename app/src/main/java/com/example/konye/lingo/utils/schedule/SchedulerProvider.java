package com.example.konye.lingo.utils.schedule;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider implements BaseScheduler {

    private static SchedulerProvider INSTANCE = null;

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SchedulerProvider();
        }
    }

    public static SchedulerProvider getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
