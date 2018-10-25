package com.mahadum360.mahadum.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

//var courseUid: Int,
//var title: String,
//var courseOwner: String,
//var courseOwnerEmail: String,
//var courseOwnerPhoneNumber: String

open class CourseRealmModel (@PrimaryKey
                             var id: Long? = 1L,
                             var courseUid: Int? = null,
                             var title: String? = null,
                             var courseOwner: String? = null,
                             var courseOwnerEmail: String? = null,
                             var courseOwnerPhoneNumber: String? = null) : RealmObject()