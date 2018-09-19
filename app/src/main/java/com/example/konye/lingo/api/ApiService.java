package com.example.konye.lingo.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    String BASEURL = "";

    //Auth Endpoints
    @POST("create")
    Call<ResponseBody> registerUser();

    @POST("login")
    Call<ResponseBody> login(String email, String password);

    //Parent Endpoints
    @POST("parent/billing")
    Call<ResponseBody> addPayment();

    @GET("parent/kids")
    Call<ResponseBody> getKidsDetails();

    @POST("parent/kids/add")
    Call<ResponseBody> addKid();

    //Teacher Endpoints
    @POST("teacher/school")
    Call<ResponseBody> teacherToSchool();

    @GET("teacher/kids")
    Call<ResponseBody> kidsInSchoolAndCourse();

    //Course Endpoints
    @GET("courses/all")
    Call<ResponseBody> getAllCourses();

    @GET("courses/{course-id}/summary")
    Call<ResponseBody> getCourseSummary(@Path("course-id") int id);

    @GET("courses/{course-id}/details")
    Call<ResponseBody> getCourseDetails(@Path("course-id") int id);

    //Lesson Endpoints
    @GET("lessons/all")
    Call<ResponseBody> getAllLessons();

    @GET("lessons/{lesson-id}")
    Call<ResponseBody> getLessonById(@Path("lesson-id") int id);

    //Kids Endpoints
    @POST("kids/register/{course-id}")
    Call<ResponseBody> registerKidToCourse(@Path("course-id") int id);

    @POST("kids/start/{course-id}")
    Call<ResponseBody> startCourse(@Path("course-id") int id);

    @GET("kids/status/{course-id}")
    Call<ResponseBody> courseProgress(@Path("course-id") int id);
}
