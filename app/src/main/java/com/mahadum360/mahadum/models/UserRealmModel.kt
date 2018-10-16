package com.mahadum360.mahadum.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


//data class User(var status: String = "",
//        var first_name: String = "",
//        var authToken: String = "",
//        var surname: String = "",
//        var email: String = "",
//        var phone_number: String = "",
//        var type: String = "",
//        var number_of_kids: String? = "",
//        var school: String? = "",
//        var courses_assigned: String? = "",
//        var kids_assigned: String? = "",
//        var loggedIn: Boolean? = false)

open class UserRealmModel (@PrimaryKey
                           var id: Long? = 0L,
                           var status: String? = null,
                           var firstName: String? = null,
                           var authToken: String? = null,
                           var surname: String? = null,
                           var email: String? = null,
                           var phoneNumber: String? = null,
                           var type: String? = null,
                           var numberOfKids: String? = null,
                           var school: String? = null,
                           var courses_assigned: String? = null,
                           var kidsAssigned: String? = null,
                           var loggedIn: Boolean = false,
                           var mahadumToken: String? = null) : RealmObject()
