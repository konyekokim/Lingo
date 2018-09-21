package com.example.konye.lingo.data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class PrefManager {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;

    @Inject
    public PrefManager(Context context, String myPreferences) {
        mSharedPreferences = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        mSharedPreferencesEditor = mSharedPreferences.edit();
    }

    public void setValue(String key, String value) {
        if (key.equals("") || value.equals("") || mSharedPreferencesEditor != null)
            mSharedPreferencesEditor.clear().commit();
        assert mSharedPreferencesEditor != null;
        mSharedPreferencesEditor.putString(key, value);
        mSharedPreferencesEditor.commit();
    }

    public String getStringValue(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public void setLogin() {
        mSharedPreferencesEditor.putBoolean("LoginFragment", true);
        mSharedPreferencesEditor.commit();
    }

    public Boolean getLogin() {
        return mSharedPreferences.getBoolean("LoginFragment", false);
    }

    public void logOut() {
        mSharedPreferencesEditor.putBoolean("LoginFragment", false);
        mSharedPreferencesEditor.commit();
    }
}
