package com.example.konye.lingo.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AuthResponse(@SerializedName("status")
                              @Expose
                              var status: String? = "",
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
