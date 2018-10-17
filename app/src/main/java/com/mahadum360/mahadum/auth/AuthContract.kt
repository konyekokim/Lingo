package com.mahadum360.mahadum.auth


import com.mahadum360.mahadum.models.*

interface AuthContract {

    interface View {
        fun hideProgress()
        fun showProgress()
        fun showComplete()
        fun showError(call: String, message: String)
        fun onLoginSuccess(user: User)
        fun onRegistrationSuccess(user: User)
        fun onValidatePasswordSuccess(response: String)
        fun onChangePasswordSuccess(response: String)
        fun onLogout()
    }

    interface Presenter {
        fun logout()
        fun login(user: LoginUser)
        fun register(user: CreateUser)
        fun validatePassword(password: PasswordRequest)
        fun changePassword(changePassword: ChangePassword)
        fun detachView()
    }
}
