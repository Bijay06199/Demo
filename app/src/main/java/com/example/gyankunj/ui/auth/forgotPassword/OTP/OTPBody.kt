package com.example.gyankunj.ui.auth.forgotPassword.OTP

data class OTPBody(val phone:String){
    override fun toString(): String {
        return "{\"phone\" : \"$phone\"}"
    }
}