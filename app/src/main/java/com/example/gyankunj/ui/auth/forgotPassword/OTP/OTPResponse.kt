package com.example.gyankunj.ui.auth.forgotPassword.OTP

import com.google.gson.annotations.SerializedName

data class OTPResponse(@SerializedName("success") val success:Int, @SerializedName("message") val message:String, @SerializedName("data")
val data:OTPData, @SerializedName("response") val response:String)