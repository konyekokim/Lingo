package com.mahadum360.mahadum.auth


import com.mahadum360.mahadum.models.CreateUser
import com.mahadum360.mahadum.models.LoginUser
import com.mahadum360.mahadum.models.User

interface AuthContract {

    interface View {
        fun hideProgress()

        fun showProgress()

        fun showComplete()

        fun showError(call: String, message: String)

        fun onLoginSuccess()

        fun onRegistrationSuccess(user: User)

        fun onLogout()
    }

    interface Presenter {
        fun logout()

        fun login(user: LoginUser)

        fun register(user: CreateUser)

        fun detachView()
    }
}
