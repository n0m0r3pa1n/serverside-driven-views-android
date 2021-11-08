package com.georgimirchev.core

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    fun default(): CoroutineDispatcher

    fun io(): CoroutineDispatcher

    fun main() : CoroutineDispatcher
}

