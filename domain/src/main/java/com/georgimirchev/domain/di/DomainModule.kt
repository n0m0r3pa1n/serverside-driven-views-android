package com.georgimirchev.domain.di

import com.georgimirchev.domain.componentdata.UiComponentDataMapper
import com.georgimirchev.domain.repository.UiComponentDataRepository
import com.georgimirchev.domain.repository.UiComponentDataRepositoryImpl
import org.koin.dsl.module

fun provideDomainModule() = module {
    factory { UiComponentDataMapper() }
    single<UiComponentDataRepository> {
        UiComponentDataRepositoryImpl(
            dispatcherProvider = get(),
            uiApi = get(),
            uiComponentDataMapper = get()
        )
    }
}
