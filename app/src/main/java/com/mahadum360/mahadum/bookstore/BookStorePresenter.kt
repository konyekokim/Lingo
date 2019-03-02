package com.mahadum360.mahadum.bookstore

import android.util.Log
import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.models.CreateBook
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class BookStorePresenter @Inject
constructor(private val apiService: ApiService,
            private val realmService: RealmService,
            private val view: BookStoreContract.View,
            private val provider: SchedulerProvider) : BookStoreContract.Presenter {
    override fun addBook(book: CreateBook) {
        view.showProgress()

        val d = apiService.addBook(realmService.getUserData()?.authToken!!, book)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({
                    val resp = it.body()
                    view.hideProgress()
                    if (it.isSuccessful) {
                        view.onAddBook(resp?.status!!)
                    } else {

                    }
                }, {
                    view.showError("add_book_error", "An error occurred")
                    Log.e("Add Book", it.message, it)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    override fun getAllBooks() {
        view.showProgress()

        val d = apiService.getAllBooks(realmService.getUserData()?.authToken!!)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({
                    val resp = it.body()
                    view.hideProgress()
                    if (it.isSuccessful) {
                        view.onGetAllBooks(resp?.books!!)
                    } else {

                    }
                }, {
                    view.showError("get_all_book_error", "An error occurred")
                    Log.e("Get All Book", it.message, it)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    override fun buyBook(bookID: Long) {
        view.showProgress()

        val d = apiService.buyABook(realmService.getUserData()?.authToken!!, bookID)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({
                    val resp = it.body()
                    view.hideProgress()
                    if (it.isSuccessful) {
                        view.onBuyBook(resp?.status!!)
                    } else {

                    }
                }, {
                    view.showError("buy_book_error", "An error occurred")
                    Log.e("Buy Book", it.message, it)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun detachView() {
        compositeDisposable.dispose()
    }
}