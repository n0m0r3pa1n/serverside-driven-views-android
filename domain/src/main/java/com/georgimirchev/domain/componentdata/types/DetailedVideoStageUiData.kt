package com.georgimirchev.domain.componentdata.types

import com.georgimirchev.domain.componentdata.UiData

class DetailedVideoStageUiData(
    override val type: String = UiDataTypes.DETAILED_VIDEO_STAGE,
    val displayName: String,
    val feedUrl: String
) : UiData
