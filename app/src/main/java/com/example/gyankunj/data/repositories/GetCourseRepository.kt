package com.example.gyankunj.data.repositories

import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.data.prefs.PreferenceManager
import com.example.gyankunj.ui.home.api.BannerResponse
import retrofit2.Response

class GetCourseRepository (val preferenceManager: PreferenceManager,val apiService: gyankunjApiService){
    suspend fun getCourse():Response<BannerResponse>{
        return apiService.getCourse(1,10)

    }
}