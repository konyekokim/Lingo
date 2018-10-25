package com.mahadum360.mahadum.learning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mahadum360.mahadum.Mahadum
import com.mahadum360.mahadum.R
import com.mahadum360.mahadum.learning.di.LearningActivityContextModule
import com.mahadum360.mahadum.models.Course
import javax.inject.Inject

class LearningActivity : AppCompatActivity(), LearningContract.View {
    override fun onGetAllCoursesSuccess(courses: List<Course>) {

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
    lateinit var presenter: LearningPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning)
        (application as Mahadum)
                .appComponent
                .add(LearningActivityContextModule(this))
                .inject(this)
    }
}
