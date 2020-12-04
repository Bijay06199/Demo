package com.example.gyankunj.data.repositories

import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.ui.auth.signIn.facebook.FacebookBody
import com.example.gyankunj.ui.auth.signIn.facebook.FinalResponses
import retrofit2.Call

class FacebookLoginRepository (private val apiService: gyankunjApiService){
    suspend fun facebookLogin( access_token:String): FinalResponses {
        val requestData=FacebookBody(access_token)
        return  apiService.facebookLogin(requestData)

    }
}