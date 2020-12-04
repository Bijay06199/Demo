package com.example.gyankunj.ui.auth.signIn.facebook

import com.google.gson.annotations.SerializedName

data class FinalResponses(@SerializedName("success") val success:Int, @SerializedName("message") val message:String,
val data: ResponseData, @SerializedName("response") val response:String)