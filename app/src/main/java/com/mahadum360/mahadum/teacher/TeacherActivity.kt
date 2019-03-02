package com.mahadum360.mahadum.teacher

import android.support.v7.app.AppCompatActivity
import com.mahadum360.mahadum.R
import android.os.Bundle
import com.mahadum360.mahadum.Mahadum
import com.mahadum360.mahadum.models.Course
import com.mahadum360.mahadum.teacher.di.TeacherActivityContextModule
import javax.inject.Inject

class TeacherActivity : AppCompatActivity(), TeacherContract.View {
    override fun getAllCoursesSuccess(courses: List<Course>) {
        //populate UI with courses
    }

    override fun hideProgress() {

    }

    override fun showProgress() {

    }

    override fun showComplete() {

    }

    override fun showError(call: String, message: String) {

    }

    @Inject
    lateinit var presenter: TeacherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        (application as Mahadum)
                .appComponent
                .add(TeacherActivityContextModule(this))
                .inject(this)
        presenter.getAllCourses()
    }
}
