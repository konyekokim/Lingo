package com.mahadum360.mahadum.data

import com.mahadum360.mahadum.models.Course
import com.mahadum360.mahadum.models.User

interface RealmInterface{

    fun closeRealm()

    //fun setLoggedIn() : Boolean

    fun setUserData(user : User) : Boolean

    fun getUserData() : User?

    fun setAllCourses(courses: List<Course>) : Boolean

    fun getAllCourses() : List<Course>?


}