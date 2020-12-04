package com.example.gyankunj.ui.auth.signIn.facebook

data class FacebookBody(val access_token:String){
    override fun toString(): String {
        return "{\"access_token\" : \"$access_token\"}"
    }
}