package com.example.gyankunj.ui.auth.signUp.signUpBody

import com.google.gson.annotations.SerializedName

data class SignUpBody(@SerializedName("phone") var phone:String, @SerializedName("otp") var otp:String,
@SerializedName("password")var password:String){
    override fun toString(): String {
 return "{\"phone\" : \"$phone\", \"otp\" :\"$otp\", \"$password\"}"

    }
}