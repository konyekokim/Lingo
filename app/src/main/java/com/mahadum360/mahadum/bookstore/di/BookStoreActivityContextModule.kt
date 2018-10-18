package com.mahadum360.mahadum.bookstore.di

import com.mahadum360.mahadum.bookstore.BookStoreContract
import com.mahadum360.mahadum.bookstore.BookStorePresenter
import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class BookStoreActivityContextModule(private val view: BookStoreContract.View){

    @Provides
    @BookStoreScope
    internal fun providesView(): BookStoreContract.View{
        return view
    }

    @Provides
    @BookStoreScope
    internal fun providesPresenter(apiService: ApiService, realmService: RealmService, view: BookStoreContract.View,
                                   provider: SchedulerProvider): BookStorePresenter{
        return BookStorePresenter(apiService, realmService, view, provider)
    }
}

