package com.georgimirchev.core.di

import com.georgimirchev.core.AndroidDispatcherProvider
import com.georgimirchev.core.DispatcherProvider
import org.koin.dsl.module

fun provideCoreModule() = module {
    single<DispatcherProvider> { AndroidDispatcherProvider }
}
