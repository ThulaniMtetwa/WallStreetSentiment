package com.example.wallstreetsentiment.android

import android.app.Application
import com.example.wallstreetsentiment.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WallStretSentimentApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@WallStretSentimentApp)
            modules(modules)
        }
    }
}