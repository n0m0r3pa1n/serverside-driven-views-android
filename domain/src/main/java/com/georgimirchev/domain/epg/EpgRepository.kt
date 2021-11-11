package com.georgimirchev.domain.epg

import com.georgimirchev.domain.models.EpgEntryModel
import com.georgimirchev.network.api.EpgApi

private const val DEFAULT_SELECTION_EPG =
    """{data{id,title,description,video{id,subType},parentalRating,channelId,startTime,endTime,images(subType:"cover"){id,subType,url},tvShow{title},episode{id,airdates,titles,number},season{id,titles,number}}}"""

class EpgRepository(
    private val epgApi: EpgApi,
    private val epgEntryMapper: EpgEntryMapper
    ) {
    suspend fun epgNowForAllBrands(): List<EpgEntryModel> {
        val epgResponse = epgApi.getEpgAllNow(
            limit = 5000,
            channels = "1,2,3,4,5,6,7",
            selection = DEFAULT_SELECTION_EPG,
        )

        return epgResponse.response.items.map(epgEntryMapper::map)
    }
}
