package com.example.gyankunj.di

import com.example.gyankunj.BuildConfig.BASE_URL
import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.data.network.NetworkConnectionInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    single {
        createOkHttpClient(NetworkConnectionInterceptor(get()))
    }

    single {

        createRetrofit<gyankunjApiService>(get())
    }
}

fun createOkHttpClient(networkConnectionInterceptor: NetworkConnectionInterceptor): OkHttpClient {


    val httpLoginInterceptor = HttpLoggingInterceptor()
    httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY


    return OkHttpClient.Builder()

        .connectTimeout(30L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoginInterceptor)
        .addInterceptor(networkConnectionInterceptor)
        .build()



}

inline fun<reified T>createRetrofit(okHttpClient: OkHttpClient):T{

    val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
//        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()

    return retrofit.create(T::class.java)
}