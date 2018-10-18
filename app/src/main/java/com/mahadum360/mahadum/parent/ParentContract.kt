package com.mahadum360.mahadum.parent

import com.mahadum360.mahadum.models.AddKid

interface ParentContract{

    interface View{
        fun hideProgress()
        fun showProgress()
        fun showComplete()
        fun showError(call: String, message: String)
        fun onAddKidSuccess(response: String)
    }

    interface Presenter{
        fun addKid(addKid: AddKid)
        fun detachView()
    }
}