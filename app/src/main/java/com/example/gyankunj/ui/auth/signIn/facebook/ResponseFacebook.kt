package com.example.gyankunj.ui.auth.signIn.facebook

import com.google.gson.annotations.SerializedName

data class ResponseFacebook(@SerializedName("email")val email:String, @SerializedName("facebook") val facebook_id:String,
                            @SerializedName("first_name")val first_name:String, @SerializedName("last_name")val last_name:String)