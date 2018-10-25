package com.mahadum360.mahadum.learning

import com.mahadum360.mahadum.models.Course

interface LearningContract{

    interface  View{
        fun hideProgress()
        fun showProgress()
        fun showComplete()
        fun onGetAllCoursesSuccess(courses: List<Course>)
        fun showError(call: String, message: String)
    }

    interface Presenter{
        fun getAllCourses()
        fun detachView()
    }
}