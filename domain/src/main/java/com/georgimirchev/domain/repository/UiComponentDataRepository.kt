package com.georgimirchev.domain.repository

import com.georgimirchev.domain.componentdata.UiComponentData

interface UiComponentDataRepository {
    suspend fun getUiComponentsData(): List<UiComponentData>
}
