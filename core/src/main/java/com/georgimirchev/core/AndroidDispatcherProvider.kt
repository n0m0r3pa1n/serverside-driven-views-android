package com.georgimirchev.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object AndroidDispatcherProvider : DispatcherProvider {

    override fun default(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override fun main(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}
