package com.georgimirchev.domain.componentdata

import com.georgimirchev.domain.componentdata.types.DetailedVideoStageUiComponentData
import com.georgimirchev.domain.componentdata.types.UiComponentDataTypes
import com.georgimirchev.network.data.ComponentJson

class UiComponentDataMapper {
    fun toUiComponentsData(mainComponents: List<ComponentJson>): List<UiComponentData> {
        return mainComponents.mapNotNull {
            if (it.type == UiComponentDataTypes.DETAILED_VIDEO_STAGE) {
                DetailedVideoStageUiComponentData(
                    type = UiComponentDataTypes.DETAILED_VIDEO_STAGE,
                    displayName = it.displayName,
                    feedUrl = it.feedUrl ?: ""
                )
            } else null
        }
    }
}
