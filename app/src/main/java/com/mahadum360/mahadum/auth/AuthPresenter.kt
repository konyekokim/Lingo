package com.mahadum360.mahadum.auth

import android.util.Log

import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.models.*
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider

import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class AuthPresenter @Inject
constructor(private val apiService: ApiService, private val realmService: RealmService, private val view: AuthContract.View,
            private val provider: SchedulerProvider) : AuthContract.Presenter {
    private val compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
    }

    override fun logout() {
        //prefManager.logOut();
        view.onLogout()
    }

    override fun login(user: LoginUser) {
        view.showProgress()

        val d = apiService.login(user)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({ r ->
                    //save here
                    val result = r.body()
                    view.hideProgress()
                    if (r.isSuccessful) {
                        assert(result != null)
                        realmService.setUserData(authResponseToUser(result!!))
                        view.onLoginSuccess(authResponseToUser(result))
                    }
                }, { error ->
                    view.showError("login_error", "An error occurred")
                    Log.e("Login", error.message, error)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    override fun register(user: CreateUser) {
        view.showProgress()

        val d = apiService.registerUser(user)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({ item ->
                    //save here
                    val result = item.body()
                    view.hideProgress()
                    if (item.isSuccessful) {
                        assert(result != null)
                        view.onRegistrationSuccess(authResponseToUser(result!!))
                        realmService.setUserData(authResponseToUser(result))
                    }
                }, { error ->
                    view.showError("login_error", "An error occurred")
                    Log.e("Login", error.message, error)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    override fun validatePassword(password: PasswordRequest) {
        view.showProgress()

        val d = apiService.validatePassword(realmService.getUserData()!!.authToken!!, password)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({response ->
                    val resp = response.body()
                    view.hideProgress()
                    if(response.isSuccessful){
                        view.onValidatePasswordSuccess(resp!!.status)
                    }
                }, { error ->
                    view.showError("validate_password_error", "An error occured")
                    Log.e("Validate Password", error.message, error)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    override fun changePassword(changePassword: ChangePassword) {
        view.showProgress()

        val d = apiService.changePassword(realmService.getUserData()!!.authToken!!, changePassword)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({resp ->
                    val r = resp.body()
                    view.hideProgress()
                    if(resp.isSuccessful){
                        view.onChangePasswordSuccess(r!!.status)
                    }
                }, { error ->
                    view.showError("change_password_error", "An error occured")
                    Log.e("Change Password", error.message, error)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    override fun detachView() {
        compositeDisposable.dispose()
    }

    private fun authResponseToUser(response: AuthResponse): User {
        val user = User()
        user.status = response.status
        user.first_name = response.firstName
        user.surname = response.surname
        user.email = response.email
        user.phone_number = response.phoneNumber
        user.type = response.type
        user.authToken = response.authToken
        return user
    }
}
