package com.example.konye.lingo.models

data class CreateUser(var email: String? = "",
                      var first_name: String? = "",
                      var surname: String? = "",
                      var reg_as: String? = "",
                      var password: String? = "",
                      var phone_number: String? = "")
