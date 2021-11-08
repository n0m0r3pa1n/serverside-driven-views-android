package com.georgimirchev.serversiderenderedviews.kdi

import com.georgimirchev.core.di.provideCoreModule
import com.georgimirchev.domain.di.provideDomainModule
import com.georgimirchev.network.di.provideNetworkingModule
import com.georgimirchev.serversiderenderedviews.ServerSideRenderedApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

fun ServerSideRenderedApplication.setupKoin() {
    startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@setupKoin)

        modules(
            listOf(
                provideCoreModule(),
                provideNetworkingModule(),
                provideMainModule(),
                provideDomainModule()
            )
        )
    }
}
