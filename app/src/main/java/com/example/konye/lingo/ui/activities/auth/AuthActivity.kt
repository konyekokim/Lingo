package com.example.konye.lingo.ui.activities.auth

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.example.konye.lingo.Mahadum
import com.example.konye.lingo.R
import com.example.konye.lingo.models.CreateUser
import com.example.konye.lingo.models.LoginUser
import com.example.konye.lingo.ui.activities.LandingPageActivity
import com.example.konye.lingo.ui.activities.auth.di.AuthActivityContextModule
import javax.inject.Inject

class AuthActivity : AppCompatActivity(), AuthContract.View,
        LoginFragment.OnFragmentInteractionListener,
        RegisterFragment.OnFragmentInteractionListener {
    override fun onSignUp(user: CreateUser?) {
        presenter.register(user!!)
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

    override fun showError(call: String?, message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onLoginSuccess() {
        val intent = Intent(this, LandingPageActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onLogout() {
        showLogin()
    }

    override fun onLogin(user: LoginUser?) {
        presenter.login(user!!)
    }

    override fun onSignUp() {
        showRegister()
    }

    @Inject
    internal lateinit var presenter: AuthPresenter

    val ROOT_TAG = AuthActivity::class.java.simpleName
    private var progressDialog: ProgressDialog? = null
    private lateinit var loginFragment: LoginFragment
    private lateinit var registerFragment: RegisterFragment
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
        if (fragment == LoginFragment())
            super.onBackPressed()
        else
            showLogin()
    }

    private fun loadFragment(fragment: Fragment) {
        this.fragment = fragment
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, ROOT_TAG)
                .commitAllowingStateLoss()
    }

    private fun showLogin() {
        loginFragment = LoginFragment.newInstance()
        loadFragment(loginFragment)
    }

    private fun showRegister() {
        registerFragment = RegisterFragment.newInstance()
        loadFragment(registerFragment)
    }
}
