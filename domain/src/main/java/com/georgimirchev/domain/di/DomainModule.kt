package com.georgimirchev.domain.di

import com.georgimirchev.domain.componentdata.UiDataMapper
import com.georgimirchev.domain.epg.EpgEntryMapper
import com.georgimirchev.domain.epg.EpgRepository
import com.georgimirchev.domain.repository.UiComponentDataRepository
import com.georgimirchev.domain.repository.UiComponentDataRepositoryImpl
import org.koin.dsl.module

fun provideDomainModule() = module {
    factory { UiDataMapper(epgRepository = get()) }
    factory { EpgEntryMapper() }
    single { EpgRepository(epgApi = get(), epgEntryMapper = get()) }
    single<UiComponentDataRepository> {
        UiComponentDataRepositoryImpl(
            dispatcherProvider = get(),
            uiApi = get(),
            uiDataMapper = get()
        )
    }
}
