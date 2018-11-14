package com.mahadum360.mahadum.data

import android.util.Log
import com.mahadum360.mahadum.models.Course
import com.mahadum360.mahadum.models.CourseRealmModel
import com.mahadum360.mahadum.models.User
import com.mahadum360.mahadum.models.UserRealmModel

import io.realm.Realm
import io.realm.RealmList

class RealmService(private val realm: Realm): RealmInterface {
    override fun closeRealm() {
        realm.close()
    }

    override fun setAllCourses(courses: List<Course>): Boolean {
        val courseList = RealmList<CourseRealmModel>()
        for(course in courses){
            courseList.add(course.toCourseRealmModel())
        }
        return try{
            realm.run{
                beginTransaction()
                copyToRealm(courseList)
                commitTransaction()
            }
            true
        } catch (e:Exception){
            Log.e("save all courses", e.message)
            false
        }
    }

    override fun getAllCourses(): List<Course>? {
        val courses = ArrayList<Course>()
        return try{
            val courseList : List<CourseRealmModel> = realm.where(CourseRealmModel::class.java).findAll()
            for(course in courseList){
                courses.add(course.toCourse())
            }
            courses
        } catch (e:Exception){
            Log.e("get all courses", e.message)
            null
        }
    }

    override fun setUserData(user: User): Boolean {
        val userRealmModel = UserRealmModel(user.id,user.status, user.first_name, user.authToken, user.surname, user.email,
                user.phone_number, user.type, user.number_of_kids, user.school, user.courses_assigned, user.kids_assigned,
                user.loggedIn)
        return try{
            realm.run{
                beginTransaction()
                copyToRealm(userRealmModel)
                commitTransaction()
            }
            true
        } catch(e: Exception){
            Log.e("save user error", e.message)
            false
        }
    }

    override fun getUserData(): User? {
        return try{
            val userRealmModel = realm.where(UserRealmModel::class.java)
                    .equalTo("id", 1L)
                    .findFirst()
            userRealmModel?.toUser()
        }catch(e : Exception){
            Log.e("get user error", e.message)
            null
        }
    }

    private fun UserRealmModel.toUser(): User{
        val user = User()
        user.authToken = this.authToken
        user.courses_assigned = this.courses_assigned
        user.email = this.email
        user.first_name = this.firstName
        user.kids_assigned = this.kidsAssigned
        user.loggedIn = this.loggedIn
        user.number_of_kids = this.numberOfKids
        user.phone_number = this.phoneNumber
        user.school = this.school
        user.status = this.status
        user.surname = this.surname
        user.type = this.type

        return user
    }

    private fun CourseRealmModel.toCourse(): Course{
        val course = Course()
        course.id = this.id
        course.title = this.title
        course.courseOwner = this.courseOwner
        course.courseUid = this.courseUid
        course.courseOwnerEmail = this.courseOwnerEmail
        course.courseOwnerPhoneNumber = this.courseOwnerPhoneNumber

        return course
    }

    private fun Course.toCourseRealmModel(): CourseRealmModel{
        val courseRealmModel = CourseRealmModel()
        courseRealmModel.id = this.id
        courseRealmModel.title = this.title
        courseRealmModel.courseOwner = this.courseOwner
        courseRealmModel.courseOwnerEmail = this.courseOwnerEmail
        courseRealmModel.courseOwnerPhoneNumber = this.courseOwnerPhoneNumber
        courseRealmModel.courseUid = this.courseUid

        return courseRealmModel
    }
}
