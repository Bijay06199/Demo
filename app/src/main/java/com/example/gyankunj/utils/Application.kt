package com.example.gyankunj.utils

import android.app.Application
import androidx.core.os.persistableBundleOf
import com.example.gyankunj.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior
import com.facebook.appevents.AppEventsLogger;

class GyankunjApp:Application(){
    override fun onCreate() {
        super.onCreate()
        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(this)
        FacebookSdk.setIsDebugEnabled(true);

        startKoin {
            androidContext(this@GyankunjApp)

            androidFileProperties()
            modules(
                listOf(
                    viewModelModule, persistenceDataModule, apiModule, appModule
                , repositoryModule
                )
            )
        }
    }
}