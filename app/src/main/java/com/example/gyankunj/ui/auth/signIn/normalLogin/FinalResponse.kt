package com.example.gyankunj.ui.auth.signIn.normalLogin

import com.google.gson.annotations.SerializedName

data class FinalResponse(@SerializedName("success")var success: Int, @SerializedName("message")var message: String, @SerializedName("data")var data: DataResponse, @SerializedName("response")var response: Int )