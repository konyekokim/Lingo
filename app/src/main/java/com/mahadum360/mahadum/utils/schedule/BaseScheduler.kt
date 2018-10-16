package com.mahadum360.mahadum.utils.schedule

import io.reactivex.Scheduler

interface BaseScheduler {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}
