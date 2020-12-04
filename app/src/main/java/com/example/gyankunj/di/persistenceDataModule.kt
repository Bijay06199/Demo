package com.example.gyankunj.di

import android.content.Context
import android.content.SharedPreferences
import com.example.gyankunj.data.prefs.PreferenceManager
import com.example.gyankunj.data.prefs.PreferenceManagerImp
import org.koin.dsl.module

val persistenceDataModule = module {
    single {
        provideSharedPreference(get(), "GyanKunj_prefs")
    }
    single {
        providePreferenceManager(get())
    }
}

fun provideSharedPreference(context: Context, preferenceName: String): SharedPreferences {
    return context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
}

fun providePreferenceManager(preferences: SharedPreferences):PreferenceManager =
    PreferenceManagerImp(preferences)