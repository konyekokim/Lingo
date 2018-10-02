package com.mahadum360.mahadum.utils.schedule;

import io.reactivex.Scheduler;

public interface BaseScheduler {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
