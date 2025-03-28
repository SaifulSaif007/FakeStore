package com.saiful.fakestore

import android.app.Application
import com.saiful.fakestore.di.appModule
import org.koin.core.context.startKoin

class FakeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}