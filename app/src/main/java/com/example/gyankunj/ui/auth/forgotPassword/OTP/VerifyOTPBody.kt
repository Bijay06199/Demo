package com.example.gyankunj.ui.auth.forgotPassword.OTP

import com.google.gson.annotations.SerializedName

data class VerifyOTPBody(@SerializedName("phone") val phone:String, @SerializedName("otp") val otp:String){

    override fun toString(): String {
        return "{\"phone\" : \"$phone\", \"otp\" : \"$otp\"}"
    }
}