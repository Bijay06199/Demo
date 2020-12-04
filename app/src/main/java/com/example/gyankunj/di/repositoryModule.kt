package com.example.gyankunj.di

import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.data.prefs.PreferenceManager
import com.example.gyankunj.data.repositories.*
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule:Module= module {
    single {
        provideFacebookLoginRepository(get())
    }

    single {
        provideForgotPasswordOTPRepository(get(),get())
    }

    single {
        provideLoginRepository(get(),get())
    }

    single {
        provideVerificationSignUpOTPRepository(get(),get())
    }

    single {
        provideSignUpRepository(get(),get())
    }

    single {
        provideCreateBannerRepository(get(),get())
    }

    single {
        provideGetBannerRepository(get())
    }

    single {
        provideGetCourseRepository(get(),get())
    }

    single {
        provideSignUpOTPRepository(get(),get())
    }

    single {
        provideVerificationForgotPasswordOTPRepository(get(),get())
    }

    single {
        provideResetPasswordRepository(get(),get())
    }


}

fun provideFacebookLoginRepository(
    apiService: gyankunjApiService
):FacebookLoginRepository{
    return FacebookLoginRepository(apiService)
}

fun provideForgotPasswordOTPRepository(
    apiService: gyankunjApiService,
    preferenceManager: PreferenceManager
):ForgotPasswordOTPRepository{
    return ForgotPasswordOTPRepository(apiService,preferenceManager)
}

fun provideSignUpOTPRepository(
    apiService: gyankunjApiService,
    preferenceManager: PreferenceManager
):SignUpOTPRepository{
    return SignUpOTPRepository(apiService,preferenceManager)
}

fun provideLoginRepository(
    apiService: gyankunjApiService,
    preferenceManager: PreferenceManager
):SignInRepository{
    return SignInRepository(apiService,preferenceManager)
}

fun provideVerificationSignUpOTPRepository(
    apiService: gyankunjApiService,
    preferenceManager: PreferenceManager
):SignUpOTPVerificationRepository{
    return SignUpOTPVerificationRepository(apiService,preferenceManager)
}

fun provideVerificationForgotPasswordOTPRepository(
    apiService: gyankunjApiService,
    preferenceManager: PreferenceManager
):ForgotPasswordOTPVerificationRepository{
    return ForgotPasswordOTPVerificationRepository(apiService,preferenceManager)
}

fun provideSignUpRepository(
    apiService: gyankunjApiService,
    preferenceManager: PreferenceManager
):SignUpRepository{
    return SignUpRepository(apiService,preferenceManager)
}

fun provideResetPasswordRepository(
    apiService: gyankunjApiService,
    preferenceManager: PreferenceManager
):ForgotPasswordRepository{
    return ForgotPasswordRepository(apiService,preferenceManager)
}

fun provideCreateBannerRepository(
    apiService: gyankunjApiService,
    preferenceManager:PreferenceManager
):CreateBannerRepository{
    return CreateBannerRepository(preferenceManager,apiService)
}

fun provideGetBannerRepository(
    apiService: gyankunjApiService
):GetBannerRepository{
    return GetBannerRepository(apiService)
}

fun provideGetCourseRepository(
    preferenceManager: PreferenceManager,
    apiService: gyankunjApiService
):GetCourseRepository{
    return GetCourseRepository(preferenceManager,apiService)
}