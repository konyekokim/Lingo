package com.example.konye.lingo.api;

import com.example.konye.lingo.models.ChangePassword;
import com.example.konye.lingo.models.CreateUser;
import com.example.konye.lingo.models.AuthResponse;
import com.example.konye.lingo.models.LoginUser;
import com.example.konye.lingo.models.PasswordRequest;
import com.example.konye.lingo.models.PasswordResponse;
import com.example.konye.lingo.models.UpdateUser;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    String BASEURL = "http://hamdanae.com/api/v1/";

    //Auth Endpoints
    @POST("create")
    Observable<Response<AuthResponse>> registerUser(@Body CreateUser user);

    @POST("update")
    Observable<Response<AuthResponse>> updateUser(@Header("MAHADUM-TOKEN") String token,
                                                  @Body UpdateUser user);

    @POST("login")
    Observable<Response<AuthResponse>> login(@Body LoginUser login);

    @POST("validatepw")
    Observable<Response<PasswordResponse>> validatePassword(@Header("MAHADUM-TOKEN") String token,
                                                            @Body PasswordRequest password);

    @POST("changepw")
    Observable<Response<PasswordResponse>> changePassword(@Header("MAHADUM-TOKEN") String token,
                                                          @Body ChangePassword change);

    //Parent Endpoints
    @POST("parent/billing")
    Call<ResponseBody> addPayment(@Header("MAHADUM-TOKEN") String token);

    @GET("parent/kids")
    Call<ResponseBody> getKidsDetails(@Header("MAHADUM-TOKEN") String token);

    @POST("parent/kids/add")
    Call<ResponseBody> addKid(@Header("MAHADUM-TOKEN") String token);

    //Teacher Endpoints
    @POST("teacher/school")
    Call<ResponseBody> teacherToSchool(@Header("MAHADUM-TOKEN") String token);

    @GET("teacher/kids")
    Call<ResponseBody> kidsInSchoolAndCourse(@Header("MAHADUM-TOKEN") String token);

    //Course Endpoints
    @GET("courses/all")
    Call<ResponseBody> getAllCourses(@Header("MAHADUM-TOKEN") String token);

    @GET("courses/{course-id}/summary")
    Call<ResponseBody> getCourseSummary(@Header("MAHADUM-TOKEN") String token,
                                        @Path("course-id") int id);

    @GET("courses/{course-id}/details")
    Call<ResponseBody> getCourseDetails(@Header("MAHADUM-TOKEN") String token,
                                        @Path("course-id") int id);

    //Lesson Endpoints
    @GET("lessons/all")
    Call<ResponseBody> getAllLessons(@Header("MAHADUM-TOKEN") String token);

    @GET("lessons/{lesson-id}")
    Call<ResponseBody> getLessonById(@Header("MAHADUM-TOKEN") String token,
                                     @Path("lesson-id") int id);

    //Kids Endpoints
    @POST("kids/register/{course-id}")
    Call<ResponseBody> registerKidToCourse(@Header("MAHADUM-TOKEN") String token,
                                           @Path("course-id") int id);

    @POST("kids/start/{course-id}")
    Call<ResponseBody> startCourse(@Header("MAHADUM-TOKEN") String token,
                                   @Path("course-id") int id);

    @GET("kids/status/{course-id}")
    Call<ResponseBody> courseProgress(@Header("MAHADUM-TOKEN") String token,
                                      @Path("course-id") int id);
}
