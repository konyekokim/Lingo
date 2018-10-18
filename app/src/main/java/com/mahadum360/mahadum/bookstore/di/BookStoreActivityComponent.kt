package com.mahadum360.mahadum.bookstore.di

import com.mahadum360.mahadum.bookstore.BookStoreActivity
import dagger.Subcomponent

@BookStoreScope
@Subcomponent(modules = [BookStoreActivityContextModule::class])
interface BookStoreActivityComponent{

    fun inject(activity: BookStoreActivity)

}