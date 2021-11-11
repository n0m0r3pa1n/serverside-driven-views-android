package com.georgimirchev.domain.componentdata.types

import com.georgimirchev.domain.componentdata.UiData
import com.georgimirchev.domain.models.ChannelIdModel
import com.georgimirchev.domain.models.EpgEntryModel

data class LiveCoverUiData(
    override val type: String = UiDataTypes.LIVE_TV,
    val data: LinkedHashMap<ChannelIdModel, ArrayList<EpgEntryModel>>
) : UiData
