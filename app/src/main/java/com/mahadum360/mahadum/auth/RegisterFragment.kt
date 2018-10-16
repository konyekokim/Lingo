package com.mahadum360.mahadum.auth

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.mahadum360.mahadum.R
import com.mahadum360.mahadum.models.CreateUser

class RegisterFragment : Fragment() {

    private lateinit var firstname: String
    private var surname: String? = null
    private var username: String? = null
    private var email: String? = null
    private var password: String? = null
    private var retypedPassword: String? = null
    private var phone: String? = null
    private lateinit var firstnameEdit: EditText
    private lateinit var surnameEdit: EditText
    private lateinit var usernameEdit: EditText
    private lateinit var emailEdit: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var retypedPasswordEdit: EditText
    private lateinit var phoneEdit: EditText
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_register, container, false)
        firstnameEdit = v.findViewById(R.id.reg_firstname_editTextView)
        surnameEdit = v.findViewById(R.id.reg_surname_editTextView)
        usernameEdit = v.findViewById(R.id.reg_username_editTextView)
        emailEdit = v.findViewById(R.id.reg_email_editTextView)
        passwordEdit = v.findViewById(R.id.reg_password_editTextView)
        retypedPasswordEdit = v.findViewById(R.id.reg_retype_password_editTextView)
        phoneEdit = v.findViewById(R.id.reg_phone_editTextView)
        val registerButton = v.findViewById<Button>(R.id.register_button)
        val signInTextView = v.findViewById<TextView>(R.id.sign_in_textVIew)

        registerButton.setOnClickListener { t -> createAccount() }

        signInTextView.setOnClickListener { t -> listener!!.onLogin() }

        return v
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener)
            listener = context
        else
            throw RuntimeException(context!!.javaClass.simpleName + " must implement " +
                    "OnFragmentInteractionListener")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun createAccount() {
        firstname = firstnameEdit.text.toString().trim { it <= ' ' }
        surname = surnameEdit.text.toString().trim { it <= ' ' }
        username = usernameEdit.text.toString().trim { it <= ' ' }
        email = emailEdit.text.toString().trim { it <= ' ' }
        password = passwordEdit.text.toString().trim { it <= ' ' }
        retypedPassword = retypedPasswordEdit.text.toString().trim { it <= ' ' }
        phone = phoneEdit.text.toString().trim { it <= ' ' }

        if (TextUtils.isEmpty(firstname)) {
            firstnameEdit.error = "please enter your first name"
            firstnameEdit.requestFocus()
        } else if (TextUtils.isEmpty(surname)) {
            surnameEdit.error = "please enter surname"
            surnameEdit.requestFocus()
        } else if (TextUtils.isEmpty(username)) {
            usernameEdit.error = "please enter username"
            usernameEdit.requestFocus()
        } else if (TextUtils.isEmpty(email)) {
            emailEdit.error = "please enter email"
            emailEdit.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEdit.error = "please enter email"
            emailEdit.requestFocus()
        } else if (TextUtils.isEmpty(password)) {
            passwordEdit.error = "please enter password"
            passwordEdit.requestFocus()
        } else if (password!!.length < 6) {
            passwordEdit.error = "Password lenght too short use at least 6 characters"
            passwordEdit.requestFocus()
        } else if (TextUtils.isEmpty(retypedPassword)) {
            retypedPasswordEdit.error = "please confirm password"
            retypedPasswordEdit.requestFocus()
        } else if (retypedPassword != password) {
            retypedPasswordEdit.error = "Passwords do not match"
            retypedPasswordEdit.requestFocus()
        } else if (TextUtils.isEmpty(phone)) {
            phoneEdit.error = "Please enter a valid phone number"
            phoneEdit.requestFocus()
        } else {
            listener!!.onSignUp(CreateUser(email, firstname, surname, "1", password,
                    phone))
        }

    }

    interface OnFragmentInteractionListener {
        fun onSignUp(user: CreateUser)

        fun onLogin()
    }

    companion object {

        fun newInstance(): RegisterFragment {
            return RegisterFragment()
        }
    }
}
