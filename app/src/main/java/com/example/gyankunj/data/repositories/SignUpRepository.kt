package com.example.gyankunj.data.repositories

import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.data.prefs.PreferenceManager
import com.example.gyankunj.ui.auth.forgotPassword.OTP.OTPResponse
import com.example.gyankunj.ui.auth.signUp.signUpBody.SignUpBody

class SignUpRepository (var apiService: gyankunjApiService,var preferenceManager: PreferenceManager){
    suspend fun userSignUp(phone:String,otp:String,password:String):OTPResponse{

        val requestData=SignUpBody(phone,otp, password)
        return apiService.signUp(requestData)
    }
}