package com.mahadum360.mahadum.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

object Util {

    internal var mToast: Toast? = null

    fun showToast(context: Context, statusMsg: String) {

        if (mToast != null) mToast!!.cancel()
        mToast = Toast.makeText(context, statusMsg, Toast.LENGTH_LONG)
        mToast!!.show()
    }

    fun checkConnection(context: Context): Boolean {
        return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo != null
    }
}