package com.example.gyankunj.data.repositories

import android.preference.PreferenceManager
import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.ui.auth.signIn.normalLogin.FinalResponse
import com.example.gyankunj.ui.auth.signIn.normalLogin.LoginBody

class SignInRepository(private val apiService: gyankunjApiService,private val preferenceManager: com.example.gyankunj.data.prefs.PreferenceManager) {
    suspend fun normalLogin(phone:String,password:String):FinalResponse{
        val requestData=LoginBody(phone,password)
        val response= apiService.login(requestData)
        if (response.message=="Success"){
            preferenceManager.setLogged(true)
        }
        return response

    }
}