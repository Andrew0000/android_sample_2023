package com.example.sampleapp3

import android.app.Application
import com.example.sampleapp3.data.dataModule
import com.example.sampleapp3.presentation.presentationModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
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
