package com.mahadum360.mahadum.auth

import android.util.Log

import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.models.AuthResponse
import com.mahadum360.mahadum.models.CreateUser
import com.mahadum360.mahadum.models.LoginUser
import com.mahadum360.mahadum.models.User
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
                    val token = r.headers().get("MAHADUM-TOKEN")
                    //prefManager.setValue("token", token);
                    val result = r.body()
                    realmService.setLoggedIn()
                    view.hideProgress()
                    if (r.isSuccessful) {
                        view.onLoginSuccess()
                        Log.e("Token", token)
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
                    val token = item.headers().get("MAHADUM-TOKEN")
                    //prefManager.setValue("token", token);
                    val result = item.body()
                    view.hideProgress()
                    if (item.isSuccessful) {
                        assert(result != null)
                        view.onRegistrationSuccess(authResponseToUser(result!!, token!!))
                        realmService.setLoggedIn()
                    }
                }, { error ->
                    view.showError("login_error", "An error occurred")
                    Log.e("Login", error.message, error)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    override fun detachView() {
        compositeDisposable.dispose()
    }

    private fun authResponseToUser(response: AuthResponse, token: String?): User {
        val user = User()
        user.status = response.status
        user.first_name = response.firstName
        user.surname = response.surname
        user.email = response.email
        user.phone_number = response.phoneNumber
        user.type = response.type
        user.authToken = token!!
        return user
    }
}
