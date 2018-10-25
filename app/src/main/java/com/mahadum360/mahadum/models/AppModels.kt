package com.mahadum360.mahadum.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AuthResponse(@SerializedName("status")
                              @Expose
                              val status: String,
                        @SerializedName("email")
                              @Expose
                              var email: String = "",
                        @SerializedName("first_name")
                              @Expose
                              var firstName: String = "",
                        @SerializedName("surname")
                              @Expose
                              var surname: String = "",
                        @SerializedName("phone_number")
                              @Expose
                              var phoneNumber: String = "",
                        @SerializedName("type")
                              @Expose
                              var type: String = "",
                        @SerializedName("mahadum_token")
                              @Expose
                              var authToken: String = "")

data class LessonDetailsResponse(@SerializedName("lesson_uid")
                                        @Expose
                                        val lessonUid: Int,
                                 @SerializedName("pdf_link")
                                        @Expose
                                        var pdfLink: String = "",
                                 @SerializedName("videos")
                                        @Expose
                                        val list: ArrayList<String>)

data class GetCourseDetailsResponse(@SerializedName("status")
                                            @Expose
                                            val status: String,
                                    @SerializedName("course_uid")
                                            @Expose
                                            val courseUid: Int,
                                    @SerializedName("title")
                                            @Expose
                                            val title: String,
                                    @SerializedName("intro_video")
                                            @Expose
                                            var introVideo: String = "",
                                    @SerializedName("intro_desc")
                                            @Expose
                                            var introDesc : String = "",
                                    @SerializedName("owner")
                                            @Expose
                                            var owner: String = "",
                                    @SerializedName("owner_email")
                                            @Expose
                                            var ownerEmail: String = "",
                                    @SerializedName("number_of_lessons")
                                            @Expose
                                            var numberOfLessons : Int = 0,
                                    @SerializedName("lesson_details")
                                            @Expose
                                            var lessonDetails: LessonDetailsResponse)

data class CourseResponse(
        @SerializedName("course_uid")
        @Expose
        var courseUid: Int,
        @SerializedName("title")
        @Expose
        var title: String,
        @SerializedName("course_owner")
        @Expose
        var courseOwner: String,
        @SerializedName("course_owner_email")
        @Expose
        var courseOwnerEmail: String,
        @SerializedName("course_owner_phone_number")
        @Expose
        var courseOwnerPhoneNumber: String)

data class GetAllCoursesResponse(
        @SerializedName("all_courses")
        @Expose
        var allCourses: ArrayList<CourseResponse>,
        @SerializedName("status")
        @Expose
        val status: String)

data class Course(
        var id: Long? = 1L,
        var courseUid: Int? = null,
        var title: String? = null,
        var courseOwner: String? = null,
        var courseOwnerEmail: String? = null,
        var courseOwnerPhoneNumber: String? = null)

data class CourseTitleAndIdResponse(
        @SerializedName("title")
        @Expose
        var title: String,
        @SerializedName("course_id")
        @Expose
        var courseUid: Int)

//data class LessonsTakenResponse()

data class KidsDetailsResponse(
        @SerializedName("kid_uid")
        @Expose
        var kidUid: Int,
        @SerializedName("first_name")
        @Expose
        var firstName: String,
        @SerializedName("surname")
        @Expose
        var surname: String,
        @SerializedName("earnings")
        @Expose
        var earnings: String,
        @SerializedName("parent")
        @Expose
        var parentName: String,
        @SerializedName("parent_email")
        @Expose
        var parentEmail: String,
        @SerializedName("parent_phone_number")
        @Expose
        var parentPhoneNumber: String,
        @SerializedName("school")
        @Expose
        var parentSchool: String,
        @SerializedName("number_of_courses")
        @Expose
        var numberOfCourses: Int,
        @SerializedName("courses")
        @Expose
        var course: CourseTitleAndIdResponse,
        @SerializedName("lessons_taken")
        @Expose
        var lessonsTaken: ArrayList<String>)

data class ChangePassword(val password: String,
                          val new_password: String)

data class CreateUser(var email: String? = "",
                      var first_name: String? = "",
                      var surname: String? = "",
                      var reg_as: String? = "",
                      var password: String? = "",
                      var phone_number: String? = "")

data class LoginUser(var email: String? = "",
                     var password: String? = "")

data class PasswordRequest(val password: String)

data class PasswordResponse(val status: String)

data class UpdateUser(val first_name: String,
                      val surname: String,
                      val phone_number: String)

data class AddKid(val first_name: String,
                  val surname: String)

data class StatusResponse(val status: String)

data class User(var id: Long? = 1L,
                var status: String? = "",
                var first_name: String? = "",
                var authToken: String? = "",
                var surname: String? = "",
                var email: String? = "",
                var phone_number: String? = "",
                var type: String? = "",
                var number_of_kids: String? = "",
                var school: String? = "",
                var courses_assigned: String? = "",
                var kids_assigned: String? = "",
                var loggedIn: Boolean? = false)