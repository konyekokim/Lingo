package com.mahadum360.mahadum.bookstore

import com.mahadum360.mahadum.models.Book
import com.mahadum360.mahadum.models.CreateBook

interface BookStoreContract{

    interface View{
        fun hideProgress()
        fun showProgress()
        fun showComplete()
        fun onGetAllBooks(books: List<Book>)
        fun onAddBook(status: String)
        fun onBuyBook(status: String)
        fun showError(call: String, message: String)
    }

    interface Presenter{
        fun addBook(book: CreateBook)
        fun getAllBooks()
        fun buyBook(bookID: Long)
        fun detachView()
    }
}