package com.georgimirchev.domain.componentdata.types

import com.georgimirchev.domain.componentdata.UiComponentData

class DetailedVideoStageUiComponentData(
    override val type: String,
    val displayName: String,
    val feedUrl: String
) : UiComponentData
