package com.georgimirchev.serversiderenderedviews

import android.app.Application
import com.georgimirchev.serversiderenderedviews.kdi.setupKoin
import timber.log.Timber

class ServerSideRenderedApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
