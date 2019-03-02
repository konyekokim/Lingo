package com.mahadum360.mahadum.teacher

import com.mahadum360.mahadum.models.Course

interface TeacherContract{

    interface View{
        fun hideProgress()
        fun showProgress()
        fun showComplete()
        fun showError(call: String, message: String)
        fun getAllCoursesSuccess(courses: List<Course>)
    }

    interface Presenter{
        fun detachView()
        fun getAllCourses()
    }

}