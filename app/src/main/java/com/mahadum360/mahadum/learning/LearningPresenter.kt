package com.mahadum360.mahadum.learning

import android.util.Log
import com.mahadum360.mahadum.data.ApiService
import com.mahadum360.mahadum.data.RealmService
import com.mahadum360.mahadum.models.Course
import com.mahadum360.mahadum.models.CourseResponse
import com.mahadum360.mahadum.utils.schedule.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LearningPresenter @Inject
constructor(private val apiService: ApiService, private val realmService: RealmService, private val view: LearningContract.View,
            private val provider: SchedulerProvider): LearningContract.Presenter{

    private val compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
    }

    override fun getAllCourses() {
        view.showProgress()
        if(realmService.getAllCourses() == null){
            allCourses()
        } else{
            if(realmService.getAllCourses()!!.isNotEmpty()){
                view.onGetAllCoursesSuccess(realmService.getAllCourses()!!)
                view.hideProgress()
            } else{
                allCourses()
            }
        }

    }

    private fun allCourses(){
        view.showProgress()

        val d = apiService.getAllCourses(realmService.getUserData()!!.authToken!!)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({r ->
                    val courses = r.body()
                    val courseList = ArrayList<Course>()
                    view.hideProgress()
                    if(r.isSuccessful){
                        assert(courses!=null)
                        for(course in courses!!.allCourses){
                            courseList.add(course.toCourse())
                        }
                        realmService.setAllCourses(courseList)
                        view.onGetAllCoursesSuccess(courseList)
                    }
                }, { error ->
                    view.showError("all courses errror", "error getting courses")
                    Log.e("All courses", error.message, error)
                    view.hideProgress()
                })
        compositeDisposable.add(d)
    }

    override fun detachView() {
        compositeDisposable.dispose()
    }


    private fun CourseResponse.toCourse(): Course {
        val course = Course()
        course.title = this.title
        course.courseOwnerPhoneNumber = this.courseOwnerPhoneNumber
        course.courseUid = this.courseUid
        course.courseOwner = this.courseOwner
        course.courseOwnerEmail = this.courseOwnerEmail

        return course
    }
}