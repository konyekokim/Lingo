package com.mahadum360.mahadum.bookstore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mahadum360.mahadum.Mahadum
import com.mahadum360.mahadum.R
import com.mahadum360.mahadum.bookstore.di.BookStoreActivityContextModule
import javax.inject.Inject

class BookStoreActivity : AppCompatActivity(), BookStoreContract.View {
    override fun hideProgress() {

    }

    override fun showProgress() {

    }

    override fun showComplete() {

    }

    override fun showError(call: String, message: String) {

    }

    @Inject
    lateinit var presenter: BookStorePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_store)
        (application as Mahadum)
                .appComponent
                .add(BookStoreActivityContextModule(this))
                .inject(this)
    }
}
