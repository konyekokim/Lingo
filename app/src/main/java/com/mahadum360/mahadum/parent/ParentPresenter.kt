package com.mahadum360.mahadum.parent

import android.util.Log
import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.models.AddKid
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ParentPresenter @Inject
constructor(private val apiService: ApiService, private val realmService: RealmService, private val view: ParentContract.View,
            private val provider: SchedulerProvider): ParentContract.Presenter{

    private val compositeDisposable: CompositeDisposable

    init{
        compositeDisposable = CompositeDisposable()
    }

    override fun addKid(addKid: AddKid) {
        view.showProgress()

        val d = apiService.addKid(realmService.getUserData()!!.authToken!!, addKid)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({resp ->
                    val r = resp.body()
                    view.hideProgress()
                    if(resp.isSuccessful){
                        view.onAddKidSuccess(r!!.status)
                    }
                }, {error ->
                    view.showError("add_kid_error", " error occurred")
                    Log.e("add_kid_error", error.message, error)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    override fun detachView() {
        compositeDisposable.dispose()
    }
}