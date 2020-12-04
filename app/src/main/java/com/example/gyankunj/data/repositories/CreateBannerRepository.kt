package com.example.gyankunj.data.repositories

import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.data.prefs.PreferenceManager
import com.example.gyankunj.ui.auth.forgotPassword.OTP.OTPResponse
import com.example.gyankunj.ui.home.api.BannerBody

class CreateBannerRepository (var preferenceManager:PreferenceManager, var apiService: gyankunjApiService){
    suspend fun createBanner(name:String,image:String):OTPResponse{
        return apiService.createBanner(
            BannerBody(
                name,
                image
            )
        )

    }
}