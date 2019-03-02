package com.mahadum360.mahadum.teacher

import com.google.android.youtube.player.internal.m
import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.models.Course
import com.mahadum360.mahadum.models.CourseResponse
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TeacherPresenter @Inject
constructor(private val apiService: ApiService, private val realmService: RealmService, private val view: TeacherContract.View,
            private val provider: SchedulerProvider): TeacherContract.Presenter{
    override fun getAllCourses() {
        view.showProgress()
        val d = apiService.getAllCourses(realmService.getUserData()!!.authToken!!)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({
                    when(it.code()){
                        200 -> {
                            val courses = ArrayList<Course>()
                            for(course in it.body()!!.allCourses)
                                courses.add(course.toCourse())
                            view.getAllCoursesSuccess(courses)
                        }
                    }
                }, {
                    view.hideProgress()
                    view.showError("Error getting courses", "Could not get courses")
                })
    }

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun detachView() {
        compositeDisposable.dispose()
    }

    private fun CourseResponse.toCourse(): Course {
        val course = Course()
        course.courseOwnerEmail = this.courseOwnerEmail
        course.courseUid = this.courseUid
        course.courseOwner = this.courseOwner
        course.title = this.title
        course.courseOwnerPhoneNumber = this.courseOwnerPhoneNumber
        return course
    }

}
