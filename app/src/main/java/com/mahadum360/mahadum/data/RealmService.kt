package com.mahadum360.mahadum.data

import com.mahadum360.mahadum.models.UserRealmModel

import io.realm.Realm

class RealmService(private val realm: Realm) {

    val isLoggedIn: Boolean
        get() {
            val user = realm.where(UserRealmModel::class.java).equalTo("id", 1L).findFirst()
            return user != null && user.loggedIn
        }

    fun closeRealm() {
        realm.close()
    }

    fun setLoggedIn() {
        realm.executeTransaction { realm ->
            val user = realm.where(UserRealmModel::class.java).equalTo("id", 1L).findFirst()
            if (user == null) {
                val userData = realm.createObject(UserRealmModel::class.java, 1L)
                userData.loggedIn = true
            } else {
                user.loggedIn = true
            }
        }
    }

    fun setUserData() {
        realm.executeTransaction { realm1 ->
            val user = realm.where(UserRealmModel::class.java).equalTo("id", 1L).findFirst()
            if (user == null) {
                val userData = realm.createObject(UserRealmModel::class.java, 1L)
                // add bodies userData here
            } else {
                //add bodies for user here
            }
        }
    }
}
