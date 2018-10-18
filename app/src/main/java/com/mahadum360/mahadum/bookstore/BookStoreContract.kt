package com.mahadum360.mahadum.bookstore

interface BookStoreContract{

    interface View{
        fun hideProgress()
        fun showProgress()
        fun showComplete()
        fun showError(call: String, message: String)
    }

    interface Presenter{
        fun detachView()
    }
}