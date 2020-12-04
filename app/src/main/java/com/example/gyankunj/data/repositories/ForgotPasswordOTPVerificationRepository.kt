package com.example.gyankunj.data.repositories

import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.data.prefs.PreferenceManager
import com.example.gyankunj.ui.auth.forgotPassword.OTP.OTPResponse
import com.example.gyankunj.ui.auth.forgotPassword.OTP.VerifyOTPBody

class ForgotPasswordOTPVerificationRepository(var apiService: gyankunjApiService, var preferenceManager: PreferenceManager) {
    suspend fun verifyOTPCode(phone:String,otp:String):OTPResponse{
        val requestData=VerifyOTPBody(phone,otp)
        return apiService.forgotPasswordverifyOTP(requestData)

    }
}