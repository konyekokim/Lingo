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
import com.mahadum360.mahadum.models.LoginUser

class LoginFragment : Fragment() {

    private lateinit var editLoginEmail: EditText
    private lateinit var editLoginPassword: EditText
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_login, container, false)

        editLoginEmail = v.findViewById(R.id.login_email_editView)
        editLoginPassword = v.findViewById(R.id.login_password_editView)
        val loginButton = v.findViewById<Button>(R.id.login_button)
        val signUpTextView = v.findViewById<TextView>(R.id.sign_up_textVIew)

        loginButton.setOnClickListener { t -> loginAccount() }
        signUpTextView.setOnClickListener { t -> listener!!.onSignUp() }

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

    private fun loginAccount() {
        if (Patterns.EMAIL_ADDRESS.matcher(editLoginEmail.text.toString().trim { it <= ' ' }).matches() && editLoginPassword.text.toString().trim { it <= ' ' }.length >= 6) {
            listener!!.onLogin(LoginUser(editLoginEmail.text.toString().trim { it <= ' ' },
                    editLoginPassword.text.toString().trim { it <= ' ' }))
            editLoginPassword.clearFocus()
            editLoginEmail.clearFocus()
        } else if (TextUtils.isEmpty(editLoginEmail.text.toString().trim { it <= ' ' })) {
            editLoginEmail.error = "This field is required."
            editLoginEmail.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(editLoginEmail.text.toString().trim { it <= ' ' }).matches()) {
            editLoginEmail.error = "Please enter a valid email address"
            editLoginEmail.requestFocus()
        } else if (TextUtils.isEmpty(editLoginPassword.text.toString().trim { it <= ' ' })) {
            editLoginPassword.error = "This field is required"
            editLoginPassword.requestFocus()
        } else if (editLoginPassword.text.toString().trim { it <= ' ' }.length < 6) {
            editLoginPassword.error = "Invalid password!"
            editLoginPassword.requestFocus()
        }
    }

    interface OnFragmentInteractionListener {
        fun onLogin(user: LoginUser)

        fun onSignUp()
    }

    companion object {

        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

}
