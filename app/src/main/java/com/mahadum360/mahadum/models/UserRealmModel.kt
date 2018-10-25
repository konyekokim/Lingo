package com.mahadum360.mahadum.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserRealmModel (@PrimaryKey
                           var id: Long? = 1L,
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
                           var loggedIn: Boolean? = false) : RealmObject()
