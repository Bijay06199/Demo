package com.example.gyankunj.data.api

import com.example.gyankunj.ui.auth.forgotPassword.OTP.OTPBody
import com.example.gyankunj.ui.auth.forgotPassword.OTP.OTPResponse
import com.example.gyankunj.ui.auth.forgotPassword.OTP.VerifyOTPBody
import com.example.gyankunj.ui.auth.signIn.facebook.FacebookBody
import com.example.gyankunj.ui.auth.signIn.facebook.FinalResponses
import com.example.gyankunj.ui.auth.signIn.normalLogin.FinalResponse
import com.example.gyankunj.ui.auth.signIn.normalLogin.LoginBody
import com.example.gyankunj.ui.auth.signUp.signUpBody.SignUpBody
import com.example.gyankunj.ui.home.api.BannerBody
import com.example.gyankunj.ui.home.api.BannerResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface gyankunjApiService {


    @POST("api/v1/en/user/fb-login")
    suspend fun facebookLogin(
        @Body params:FacebookBody
    ): FinalResponses


    @POST("api/v1/en/user/send-phone-code")
    suspend fun otp(
        @Body params: OTPBody
    ):OTPResponse

    @POST("api/v1/en/user/forgot-password")
    suspend fun otpForgotPassword(
        @Body params: OTPBody
    ):OTPResponse


    @POST("api/v1/en/user/login")
    suspend fun login(
        @Body params:LoginBody
    ):FinalResponse

    @POST("api/v1/en/user/verify-phone-code")
    suspend fun verifyOTP(
        @Body params: VerifyOTPBody
    ):OTPResponse

    @POST("api/v1/en/user/valid-forgot-token")
    suspend fun forgotPasswordverifyOTP(
        @Body params: VerifyOTPBody
    ):OTPResponse

    @POST("api/v1/en/user/signup")
    suspend fun signUp(
        @Body params: SignUpBody
    ):OTPResponse

    @POST("api/v1/en/user/change-forgot-password")
    suspend fun forgotPassword(
        @Body params: SignUpBody
    ):OTPResponse

    @POST("api/v1/en/banner/create")
    suspend fun createBanner(
        @Body params: BannerBody
    ):OTPResponse

    @GET("/api/v1/en/banner")
   suspend fun getBanner(
        @Query("page")page:Int,
        @Query("perPage")perPage:Int
    ):Response<BannerResponse>

    @GET("api/v1/en/course")
    suspend fun getCourse(
        @Query("page")page:Int,
        @Query("perPage")perPage:Int
    ):Response<BannerResponse>
}