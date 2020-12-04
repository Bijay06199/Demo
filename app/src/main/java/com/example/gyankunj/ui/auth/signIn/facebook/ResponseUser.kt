package com.example.gyankunj.ui.auth.signIn.facebook

import com.google.gson.annotations.SerializedName

data class ResponseUser(val local:ResponseLocal, val facebook:ResponseFacebook, @SerializedName("role") val role:Int,

                        @SerializedName("logged_from") val logged_from:String, @SerializedName("is_archieved") val is_archieved:Boolean,
                        @SerializedName("_id") val _id:String, @SerializedName("phone") val phone:String, @SerializedName("createdAt") val createdAt:String,
                        @SerializedName("_v") val _v:Int
                        )