package com.example.gyankunj.ui.auth.signIn.normalLogin

import com.google.gson.annotations.SerializedName

data class LoginBody(@SerializedName("phone") var phone:String, @SerializedName("password")var password:String){
    override fun toString(): String {
        return "{\"phone\" : \"$phone\", \"password\" : \"$password\"}"
    }
}