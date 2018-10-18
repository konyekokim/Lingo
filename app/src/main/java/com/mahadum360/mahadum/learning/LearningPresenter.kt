package com.mahadum360.mahadum.learning

import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LearningPresenter @Inject
constructor(private val apiService: ApiService, private val realmService: RealmService, private val view: LearningContract.View,
            private val provider: SchedulerProvider): LearningContract.Presenter{

    private val compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
    }
}