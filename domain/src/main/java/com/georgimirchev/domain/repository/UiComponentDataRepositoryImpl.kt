package com.georgimirchev.domain.repository

import com.georgimirchev.core.DispatcherProvider
import com.georgimirchev.domain.componentdata.UiComponentData
import com.georgimirchev.domain.componentdata.UiComponentDataMapper
import com.georgimirchev.network.api.UiApi
import kotlinx.coroutines.withContext

class UiComponentDataRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val uiApi: UiApi,
    private val uiComponentDataMapper: UiComponentDataMapper
) : UiComponentDataRepository {
    override suspend fun getUiComponentsData(): List<UiComponentData> = withContext(dispatcherProvider.main()) {
        val components = uiApi.getLayout("home")
        val mainComponents = components.response.components.main
        uiComponentDataMapper.toUiComponentsData(mainComponents)
    }
}
