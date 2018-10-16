package com.mahadum360.mahadum.data

import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject

class PrefManager @Inject
constructor(context: Context, myPreferences: String) {
    private val mSharedPreferences: SharedPreferences
    private val mSharedPreferencesEditor: SharedPreferences.Editor?

    val login: Boolean?
        get() = mSharedPreferences.getBoolean("LoginFragment", false)

    init {
        mSharedPreferences = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        mSharedPreferencesEditor = mSharedPreferences.edit()
    }

    fun setValue(key: String, value: String) {
        if (key == "" || value == "" || mSharedPreferencesEditor != null)
            mSharedPreferencesEditor!!.clear().commit()
        assert(mSharedPreferencesEditor != null)
        mSharedPreferencesEditor!!.putString(key, value)
        mSharedPreferencesEditor.commit()
    }

    fun getStringValue(key: String, defaultValue: String): String? {
        return mSharedPreferences.getString(key, defaultValue)
    }

    fun setLogin() {
        mSharedPreferencesEditor!!.putBoolean("LoginFragment", true)
        mSharedPreferencesEditor.commit()
    }

    fun logOut() {
        mSharedPreferencesEditor!!.putBoolean("LoginFragment", false)
        mSharedPreferencesEditor.commit()
    }
}
