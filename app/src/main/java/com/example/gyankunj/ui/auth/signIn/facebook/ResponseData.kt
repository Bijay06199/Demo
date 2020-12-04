package com.example.gyankunj.ui.auth.signIn.facebook

import com.google.gson.annotations.SerializedName

data class ResponseData(@SerializedName("access_token") val access_token:String, @SerializedName("refresh_token") val refresh_token:String,
                        val user: ResponseUser
                        )