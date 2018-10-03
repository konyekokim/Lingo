package com.mahadum360.mahadum.auth;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.models.LoginUser;

public class LoginFragment extends Fragment {

    EditText editLoginEmail, editLoginPassword;
    private OnFragmentInteractionListener listener;

    public LoginFragment() {

    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        editLoginEmail = v.findViewById(R.id.login_email_editView);
        editLoginPassword = v.findViewById(R.id.login_password_editView);
        Button loginButton = v.findViewById(R.id.login_button);
        TextView signUpTextView = v.findViewById(R.id.sign_up_textVIew);

        loginButton.setOnClickListener(t -> loginAccount());
        signUpTextView.setOnClickListener(t -> listener.onSignUp());

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
            listener = (OnFragmentInteractionListener) context;
        else
            throw new RuntimeException(context.getClass().getSimpleName() + " must implement " +
                    "OnFragmentInteractionListener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void loginAccount() {
        if (Patterns.EMAIL_ADDRESS.matcher(editLoginEmail.getText().toString().trim()).matches()
                && editLoginPassword.getText().toString().trim().length() >= 6) {
            listener.onLogin(new LoginUser(editLoginEmail.getText().toString().trim(),
                    editLoginPassword.getText().toString().trim()));
            editLoginPassword.clearFocus();
            editLoginEmail.clearFocus();
        } else if (TextUtils.isEmpty(editLoginEmail.getText().toString().trim())) {
            editLoginEmail.setError("This field is required.");
            editLoginEmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(editLoginEmail.getText().toString().trim()).matches()) {
            editLoginEmail.setError("Please enter a valid email address");
            editLoginEmail.requestFocus();
        } else if (TextUtils.isEmpty(editLoginPassword.getText().toString().trim())) {
            editLoginPassword.setError("This field is required");
            editLoginPassword.requestFocus();
        } else if (editLoginPassword.getText().toString().trim().length() < 6) {
            editLoginPassword.setError("Invalid password!");
            editLoginPassword.requestFocus();
        }
    }

    public interface OnFragmentInteractionListener {
        void onLogin(LoginUser user);

        void onSignUp();
    }

}
