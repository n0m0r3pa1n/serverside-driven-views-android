package com.georgimirchev.domain.repository

import com.georgimirchev.core.DispatcherProvider
import com.georgimirchev.domain.componentdata.UiData
import com.georgimirchev.domain.componentdata.UiDataMapper
import com.georgimirchev.network.api.UiApi
import kotlinx.coroutines.withContext

class UiComponentDataRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val uiApi: UiApi,
    private val uiDataMapper: UiDataMapper
) : UiComponentDataRepository {
    override suspend fun getUiComponentsData(): List<UiData> = withContext(dispatcherProvider.main()) {
        val components = uiApi.getLayout("home")
        val mainComponents = components.response.components.main
        uiDataMapper.toUiData(mainComponents)
    }
}
