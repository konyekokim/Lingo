package com.mahadum360.mahadum.auth

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.mahadum360.mahadum.Mahadum
import com.mahadum360.mahadum.R
import com.mahadum360.mahadum.models.CreateUser
import com.mahadum360.mahadum.models.LoginUser
import com.mahadum360.mahadum.ui.activities.LandingPageActivity
import com.mahadum360.mahadum.auth.di.AuthActivityContextModule
import com.mahadum360.mahadum.auth.fragments.LoginFragment
import com.mahadum360.mahadum.auth.fragments.RegisterFragment
import com.mahadum360.mahadum.auth.fragments.WelcomeFragment
import com.mahadum360.mahadum.bookstore.BookStoreActivity
import com.mahadum360.mahadum.learning.LearningActivity
import com.mahadum360.mahadum.models.User
import com.mahadum360.mahadum.teacher.TeacherActivity
import javax.inject.Inject

class AuthActivity : AppCompatActivity(), AuthContract.View,
        LoginFragment.OnFragmentInteractionListener,
        RegisterFragment.OnFragmentInteractionListener,
        WelcomeFragment.OnFragmentInteractionListener{
    override fun onEnterLearnClicked() {
        startActivity(Intent(this@AuthActivity, LearningActivity::class.java))
    }

    override fun onExploreBookStoreClicked() {
        startActivity(Intent(this@AuthActivity, BookStoreActivity::class.java))
    }

    override fun onChangePasswordSuccess(response: String) {
    }

    override fun onValidatePasswordSuccess(response: String) {
    }

    override fun onRegistrationSuccess(user: User) {
        /*val intent = Intent(this, LandingPageActivity::class.java)
        startActivity(intent)
        finish()*/
        if(user.type == "parent")
            showWelcome()
        else
            startActivity(Intent(this@AuthActivity, TeacherActivity::class.java))
    }

    override fun onSignUp(user: CreateUser) {
        presenter.register(user)
    }

    override fun onLogin() {
        showLogin()
    }

    override fun hideProgress() {
        if (progressDialog != null)
            progressDialog!!.dismiss()
    }

    override fun showProgress() {
        if (progressDialog != null) {
            progressDialog!!.setMessage("Signing in")
            progressDialog!!.show()
        } else {
            progressDialog = ProgressDialog(this)
            progressDialog!!.setMessage("Signing in")
            progressDialog!!.show()
        }
    }

    override fun showComplete() {
        if (progressDialog != null)
            progressDialog!!.dismiss()
    }

    override fun showError(call: String, message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onLoginSuccess(user: User) {
        /*val intent = Intent(this, LandingPageActivity::class.java)
        startActivity(intent)
        finish()*/
        if(user.type == "parent")
            showWelcome()
        else
            startActivity(Intent(this@AuthActivity, TeacherActivity::class.java))
    }

    override fun onLogout() {
        showLogin()
    }

    override fun onLogin(user: LoginUser) {
        presenter.login(user)
    }

    override fun onSignUp() {
        showRegister()
    }

    @Inject
    internal lateinit var presenter: AuthPresenter

    val ROOT_TAG = AuthActivity::class.java.simpleName
    private var progressDialog: ProgressDialog? = null
    private var loginFragment: LoginFragment? = null
    private var registerFragment: RegisterFragment? = null
    private var welcomeFragment: WelcomeFragment? = null
    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        progressDialog = ProgressDialog(this)
        (application as Mahadum)
                .appComponent
                .add(AuthActivityContextModule(this))
                .inject(this)

        if (intent != null && intent.extras != null && intent.hasExtra("where")) {
            if (intent.extras.getString("where") == "login")
                showLogin()
            else
                showRegister()
        } else
            showLogin()
    }

    override fun onBackPressed() {
        if (loginFragment != null && loginFragment!!.isAdded) {
            super.onBackPressed()
            finish()
        } else
            showLogin()
    }

    private fun loadFragment(fragment: Fragment) {
        this.fragment = fragment
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, ROOT_TAG)
                .commitAllowingStateLoss()
    }

    private fun showLogin() {
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance()
        }
        loadFragment(loginFragment!!)
    }

    private fun showRegister() {
        if (registerFragment == null) {
            registerFragment = RegisterFragment.newInstance()
        }
        loadFragment(registerFragment!!)
    }

    private fun showWelcome(){
        if (welcomeFragment == null)
            welcomeFragment = WelcomeFragment.newInstance()
        loadFragment(welcomeFragment!!)
    }
}
