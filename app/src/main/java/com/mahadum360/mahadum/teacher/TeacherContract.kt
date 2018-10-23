package com.mahadum360.mahadum.teacher

interface TeacherContract{

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