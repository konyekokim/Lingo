package com.mahadum360.mahadum.bookstore

import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class BookStorePresenter @Inject
constructor(private val apiService: ApiService, private val realmService: RealmService, private val view: BookStoreContract.View,
            private val provide: SchedulerProvider): BookStoreContract.Presenter{

    private val compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView() {

    }
}