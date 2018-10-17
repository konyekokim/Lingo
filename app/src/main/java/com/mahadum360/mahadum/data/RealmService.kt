package com.mahadum360.mahadum.data

import android.util.Log
import com.mahadum360.mahadum.models.User
import com.mahadum360.mahadum.models.UserRealmModel

import io.realm.Realm

class RealmService(private val realm: Realm): RealmInterface {

    override fun closeRealm() {
        realm.close()
    }

//    override fun setLoggedIn(): Boolean {
//        realm.executeTransaction { realm ->
//            val user = realm.where(UserRealmModel::class.java).equalTo("id", 1L).findFirst()
//            if (user == null) {
//                val userData = realm.createObject(UserRealmModel::class.java, 1L)
//                userData.loggedIn = true
//            } else {
//                user.loggedIn = true
//            }
//        }
//    }

    override fun setUserData(user: User): Boolean {
        val userRealmModel = UserRealmModel(user.id,user.status, user.first_name, user.authToken, user.surname, user.email,
                user.phone_number, user.type, user.number_of_kids, user.school, user.courses_assigned, user.kids_assigned,
                user.loggedIn)
        return try{
            realm.run{
                beginTransaction()
                copyToRealm(userRealmModel)
                commitTransaction()
            }
            true
        } catch(e: Exception){
            Log.e("save user error", e.message)
            false
        }
    }

    override fun getUserData(): User? {
        return try{
            val userRealmModel = realm.where(UserRealmModel::class.java)
                    .equalTo("id", 1L)
                    .findFirst()
            userRealmModel?.toUser()
        }catch(e : Exception){
            Log.e("get user error", e.message)
            null
        }
    }

    private fun UserRealmModel.toUser(): User{
        val user = User()
        user.authToken = this.authToken
        user.courses_assigned = this.courses_assigned
        user.email = this.email
        user.first_name = this.firstName
        user.kids_assigned = this.kidsAssigned
        user.loggedIn = this.loggedIn
        user.number_of_kids = this.numberOfKids
        user.phone_number = this.phoneNumber
        user.school = this.school
        user.status = this.status
        user.surname = this.surname
        user.type = this.type

        return user
    }
}
