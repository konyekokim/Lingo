package com.mahadum360.mahadum.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AuthResponse(@SerializedName("status")
                              @Expose
                              val status: String,
                        @SerializedName("MAHADUM-TOKEN")
                              @Expose
                              var auth_token: String? = "",
                        @SerializedName("email")
                              @Expose
                              var email: String? = "",
                        @SerializedName("first_name")
                              @Expose
                              var firstName: String? = "",
                        @SerializedName("surname")
                              @Expose
                              var surname: String? = "",
                        @SerializedName("phone_number")
                              @Expose
                              var phoneNumber: String? = "",
                        @SerializedName("type")
                              @Expose
                              var type: String? = "")

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

data class User(val status: String,
                val first_name: String,
                val surname: String,
                val email: String,
                val phone_number: String,
                val type: String,
                var number_of_kids: String? = "",
                var school: String? = "",
                var courses_assigned: String? = "",
                var kids_assigned: String? = "")