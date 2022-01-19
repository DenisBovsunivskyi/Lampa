package com.fourksoft.network.app

import android.app.Application
import android.content.Context
import com.example.lampa.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        appInstance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        @Volatile
        private lateinit var appInstance: AndroidApplication

        val applicationContext: Context
            get() = appInstance.applicationContext
    }
}