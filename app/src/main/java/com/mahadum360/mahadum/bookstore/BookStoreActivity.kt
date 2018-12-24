package com.mahadum360.mahadum.bookstore

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.TextView
import com.mahadum360.mahadum.Mahadum
import com.mahadum360.mahadum.R
import com.mahadum360.mahadum.bookstore.adapters.BookStoreViewPagerAdapter
import com.mahadum360.mahadum.bookstore.di.BookStoreActivityContextModule
import com.mahadum360.mahadum.bookstore.fragments.MyBooksFragment
import com.mahadum360.mahadum.bookstore.fragments.ParentStoreFragment
import com.mahadum360.mahadum.models.Book
import kotlinx.android.synthetic.main.activity_book_store.*
import javax.inject.Inject

class BookStoreActivity : AppCompatActivity(), BookStoreContract.View,
        ParentStoreFragment.OnFragmentInteractionListener,
        MyBooksFragment.OnFragmentInteractionListener {
    override fun getRecommended() {

    }

    override fun getMostRecent() {

    }

    override fun getBestSellers() {

    }

    override fun onGetAllBooks(books: List<Book>) {

    }

    override fun onAddBook(status: String) {

    }

    override fun onBuyBook(status: String) {

    }

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
        initViews()
    }

    private fun initViews() {
        setupViewPager()
        tabs.setupWithViewPager(viewPager)
        setupTabs()
        backButton.setOnClickListener {
            //todo implement back function
        }
    }

    @SuppressLint("InflateParams")
    private fun setupTabs() {
        val tabOne = LayoutInflater.from(this).inflate(R.layout.custom_tab_layout,
                null) as TextView
        tabOne.text = ("Parent Store")
        tabs.getTabAt(0)!!.customView = tabOne
        val tabTwo = LayoutInflater.from(this).inflate(R.layout.custom_tab_layout,
                null) as TextView
        tabTwo.text = ("My Books")
        tabs.getTabAt(1)!!.customView = tabTwo
    }

    private fun setupViewPager() {
        val adapter = BookStoreViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ParentStoreFragment(), "Parent Store")
        adapter.addFragment(MyBooksFragment(), "My Books")
        viewPager.adapter = adapter
    }
}
