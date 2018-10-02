package com.mahadum360.mahadum.ui.activities.auth;

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
import com.mahadum360.mahadum.models.CreateUser;

public class RegisterFragment extends Fragment {

    String firstname, surname, username, email, password, retypedPassword, phone;
    EditText firstnameEdit, surnameEdit, usernameEdit, emailEdit, passwordEdit,
            retypedPasswordEdit, phoneEdit;
    private OnFragmentInteractionListener listener;

    public RegisterFragment() {

    }

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        firstnameEdit = v.findViewById(R.id.reg_firstname_editTextView);
        surnameEdit = v.findViewById(R.id.reg_surname_editTextView);
        usernameEdit = v.findViewById(R.id.reg_username_editTextView);
        emailEdit = v.findViewById(R.id.reg_email_editTextView);
        passwordEdit = v.findViewById(R.id.reg_password_editTextView);
        retypedPasswordEdit = v.findViewById(R.id.reg_retype_password_editTextView);
        phoneEdit = v.findViewById(R.id.reg_phone_editTextView);
        Button registerButton = v.findViewById(R.id.register_button);
        TextView signInTextView = v.findViewById(R.id.sign_in_textVIew);

        registerButton.setOnClickListener(t -> createAccount());

        signInTextView.setOnClickListener(t -> listener.onLogin());

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

    private void createAccount() {
        firstname = firstnameEdit.getText().toString().trim();
        surname = surnameEdit.getText().toString().trim();
        username = usernameEdit.getText().toString().trim();
        email = emailEdit.getText().toString().trim();
        password = passwordEdit.getText().toString().trim();
        retypedPassword = retypedPasswordEdit.getText().toString().trim();
        phone = phoneEdit.getText().toString().trim();

        if (TextUtils.isEmpty(firstname)) {
            firstnameEdit.setError("please enter your first name");
            firstnameEdit.requestFocus();
        } else if (TextUtils.isEmpty(surname)) {
            surnameEdit.setError("please enter surname");
            surnameEdit.requestFocus();
        } else if (TextUtils.isEmpty(username)) {
            usernameEdit.setError("please enter username");
            usernameEdit.requestFocus();
        } else if (TextUtils.isEmpty(email)) {
            emailEdit.setError("please enter email");
            emailEdit.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEdit.setError("please enter email");
            emailEdit.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            passwordEdit.setError("please enter password");
            passwordEdit.requestFocus();
        } else if (password.length() < 6) {
            passwordEdit.setError("Password lenght too short use at least 6 characters");
            passwordEdit.requestFocus();
        } else if (TextUtils.isEmpty(retypedPassword)) {
            retypedPasswordEdit.setError("please confirm password");
            retypedPasswordEdit.requestFocus();
        } else if (!retypedPassword.equals(password)) {
            retypedPasswordEdit.setError("Passwords do not match");
            retypedPasswordEdit.requestFocus();
        } else if (TextUtils.isEmpty(phone)) {
            phoneEdit.setError("Please enter a valid phone number");
            phoneEdit.requestFocus();
        } else {
            listener.onSignUp(new CreateUser(email, firstname, surname, "1", password,
                    phone));
        }

    }

    public interface OnFragmentInteractionListener {
        void onSignUp(CreateUser user);

        void onLogin();
    }
}
