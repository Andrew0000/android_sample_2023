package com.example.sampleapp3

import android.app.Application
import com.example.sampleapp3.data.di.dataModule
import com.example.sampleapp3.presentation.di.presentationModule
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        initDI()
    }

    private fun initDI() {
        startKoin {
            modules(
                dataModule,
                presentationModule,
            )
        }
    }
}
