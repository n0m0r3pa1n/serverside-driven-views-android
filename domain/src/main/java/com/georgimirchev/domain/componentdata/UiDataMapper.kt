package com.georgimirchev.domain.componentdata

import com.georgimirchev.domain.componentdata.types.DetailedVideoStageUiData
import com.georgimirchev.domain.componentdata.types.LiveCoverUiData
import com.georgimirchev.domain.epg.EpgRepository
import com.georgimirchev.domain.models.ChannelIdModel
import com.georgimirchev.domain.models.EpgEntryModel
import com.georgimirchev.network.data.ComponentJson
import com.georgimirchev.network.data.ServerRowDataType

class UiDataMapper(private val epgRepository: EpgRepository) {
    suspend fun toUiData(mainComponents: List<ComponentJson>): List<UiData> {
        return mainComponents.mapNotNull {
            when  (it.type) {
                ServerRowDataType.DETAILED_VIDEO_STAGE -> DetailedVideoStageUiData(
                    displayName = it.displayName,
                    feedUrl = it.feedUrl ?: ""
                )
                ServerRowDataType.LIVE_TV -> mapLiveLanesToState(it)
                else -> null
            }
        }
    }

    private suspend fun mapLiveLanesToState(component: ComponentJson): UiData {
        val epgs = epgRepository.epgNowForAllBrands()
        val epgMap = LinkedHashMap<ChannelIdModel, ArrayList<EpgEntryModel>>()
        epgs.forEach { epg ->
            var list = epgMap[ChannelIdModel(epg.channelId)]
            if (list == null) {
                list = ArrayList()
                epgMap[ChannelIdModel(epg.channelId)] = list
            }
            list.add(epg)
        }

        return LiveCoverUiData(data = epgMap)
    }
}
