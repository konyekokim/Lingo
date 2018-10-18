package com.mahadum360.mahadum.learning

interface LearningContract{

    interface  View{
        fun hideProgress()
        fun showProgress()
        fun showComplete()
        fun showError(call: String, message: String)
    }

    interface Presenter{
        fun detachView()
    }
}