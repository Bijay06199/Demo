package com.example.gyankunj.data.repositories

import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.data.prefs.PreferenceManager
import com.example.gyankunj.ui.auth.forgotPassword.OTP.OTPBody
import com.example.gyankunj.ui.auth.forgotPassword.OTP.OTPResponse

class SignUpOTPRepository(val apiService: gyankunjApiService, val preferenceManager: PreferenceManager) {
    suspend fun sendCode(phone:String): OTPResponse {
        val requestData= OTPBody(phone)
        return apiService.otp(requestData)
    }
}