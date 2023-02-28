package com.apps

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.*

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            defaultModule()
            androidLogger()
            androidContext(this@MainApp)
        }
    }
}