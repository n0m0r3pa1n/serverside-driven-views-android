package com.georgimirchev.domain.repository

import com.georgimirchev.domain.componentdata.UiData

interface UiComponentDataRepository {
    suspend fun getUiComponentsData(): List<UiData>
}
