package com.mahadum360.mahadum.teacher

import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TeacherPresenter @Inject
constructor(private val apiService: ApiService, private val realmService: RealmService, private val view: TeacherContract.View,
            private val provider: SchedulerProvider): TeacherContract.Presenter{
    private val compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView() {

    }

}
