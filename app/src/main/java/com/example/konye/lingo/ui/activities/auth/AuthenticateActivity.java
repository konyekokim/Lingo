package com.example.konye.lingo.ui.activities.auth;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.konye.lingo.Mahadum;
import com.example.konye.lingo.R;
import com.example.konye.lingo.di.component.AppComponent;
import com.example.konye.lingo.models.CreateUser;
import com.example.konye.lingo.models.LoginUser;
import com.example.konye.lingo.ui.activities.LandingPageActivity;
import com.example.konye.lingo.ui.activities.auth.di.AuthActivityContextModule;
import com.example.konye.lingo.ui.activities.register.RegisterFragment;

import java.util.Objects;

import javax.inject.Inject;

public class AuthenticateActivity extends AppCompatActivity implements AuthContract.View,
        LoginFragment.OnFragmentInteractionListener,
        RegisterFragment.OnFragmentInteractionListener {

    private static final String ROOT_TAG = AuthenticateActivity.class.getSimpleName();
    private ProgressDialog progressDialog = null;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    private Fragment fragment;

    @Inject
    AuthPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);

        progressDialog = new ProgressDialog(this);
        ((Mahadum) getApplication())
                .getAppComponent()
                .add(new AuthActivityContextModule(this))
                .inject(this);
        if (savedInstanceState != null) {
            if (Objects.equals(savedInstanceState.getString("where"), "login"))
                showLogin();
            else if (Objects.equals(savedInstanceState.getString("where"), "register"))
                showRegister();
        } else {
            showLogin();
        }
    }

    @Override
    public void onBackPressed() {
        if (fragment instanceof LoginFragment)
            super.onBackPressed();
        else
            showLogin();
    }

    private void loadFragment(Fragment fragment) {
        this.fragment = fragment;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, ROOT_TAG)
                .commitAllowingStateLoss();
    }

    private void showLogin() {
        loginFragment = LoginFragment.newInstance();
        loadFragment(loginFragment);
    }

    private void showRegister() {
        registerFragment = RegisterFragment.newInstance();
        loadFragment(registerFragment);
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    @Override
    public void showProgress() {
        if (progressDialog != null) {
            progressDialog.setMessage("Signing in");
            progressDialog.show();
        } else {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Signing in");
            progressDialog.show();
        }
    }

    @Override
    public void showComplete() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    @Override
    public void showError(String call, String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(this, LandingPageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLogout() {
        showLogin();
    }

    @Override
    public void onLogin(LoginUser user) {
        presenter.login(user);
    }

    @Override
    public void onSignUp() {
        showRegister();
    }

    @Override
    public void onSignUp(CreateUser user) {
        presenter.register(user);
    }

    @Override
    public void onLogin() {
        showLogin();
    }
}
