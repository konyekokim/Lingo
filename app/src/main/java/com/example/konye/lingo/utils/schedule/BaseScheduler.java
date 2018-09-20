package com.example.konye.lingo.utils.schedule;

import io.reactivex.Scheduler;

public interface BaseScheduler {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
