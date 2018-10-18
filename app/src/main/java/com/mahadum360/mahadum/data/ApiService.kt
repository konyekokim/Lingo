package com.mahadum360.mahadum.data


import com.mahadum360.mahadum.models.*

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    //Auth Endpoints
    @POST("create")
    fun registerUser(@Body user: CreateUser): Observable<Response<AuthResponse>>

    @POST("update")
    fun updateUser(@Header("MAHADUM-TOKEN") token: String,
                   @Body user: UpdateUser): Observable<Response<AuthResponse>>

    @POST("login")
    fun login(@Body login: LoginUser): Observable<Response<AuthResponse>>

    @POST("validatepw")
    fun validatePassword(@Header("MAHADUM-TOKEN") token: String,
                         @Body password: PasswordRequest): Observable<Response<PasswordResponse>>

    @POST("changepw")
    fun changePassword(@Header("MAHADUM-TOKEN") token: String,
                       @Body change: ChangePassword): Observable<Response<PasswordResponse>>

    //Parent Endpoints
    @POST("parent/billing")
    fun addPayment(@Header("MAHADUM-TOKEN") token: String): Call<ResponseBody>

    @GET("parent/kids")
    fun getKidsDetails(@Header("MAHADUM-TOKEN") token: String): Call<ResponseBody>

    @POST("parent/addkid")
    fun addKid(@Header("MAHADUM-TOKEN") token: String,
               @Body addKid: AddKid): Observable<Response<StatusResponse>>

    //Teacher Endpoints
    @POST("teacher/school")
    fun teacherToSchool(@Header("MAHADUM-TOKEN") token: String): Call<ResponseBody>

    @GET("teacher/kids")
    fun kidsInSchoolAndCourse(@Header("MAHADUM-TOKEN") token: String): Call<ResponseBody>

    //Course Endpoints
    @GET("courses/all")
    fun getAllCourses(@Header("MAHADUM-TOKEN") token: String): Call<ResponseBody>

    @GET("courses/{course-id}/summary")
    fun getCourseSummary(@Header("MAHADUM-TOKEN") token: String,
                         @Path("course-id") id: Int): Call<ResponseBody>

    @GET("courses/{course-id}/details")
    fun getCourseDetails(@Header("MAHADUM-TOKEN") token: String,
                         @Path("course-id") id: Int): Call<ResponseBody>

    //Lesson Endpoints
    @GET("lessons/all")
    fun getAllLessons(@Header("MAHADUM-TOKEN") token: String): Call<ResponseBody>

    @GET("lessons/{lesson-id}")
    fun getLessonById(@Header("MAHADUM-TOKEN") token: String,
                      @Path("lesson-id") id: Int): Call<ResponseBody>

    //Kids Endpoints
    @POST("kids/register/{course-id}")
    fun registerKidToCourse(@Header("MAHADUM-TOKEN") token: String,
                            @Path("course-id") id: Int): Call<ResponseBody>

    @POST("kids/start/{course-id}")
    fun startCourse(@Header("MAHADUM-TOKEN") token: String,
                    @Path("course-id") id: Int): Call<ResponseBody>

    @GET("kids/status/{course-id}")
    fun courseProgress(@Header("MAHADUM-TOKEN") token: String,
                       @Path("course-id") id: Int): Call<ResponseBody>

    companion object {
        val BASEURL = "http://hamdanae.com/api/v1/"
    }
}
