package com.georgimirchev.serversiderenderedviews.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.georgimirchev.domain.componentdata.UiData
import com.georgimirchev.domain.componentdata.types.UiDataTypes
import com.georgimirchev.serversiderenderedviews.databinding.ViewDetailedVideoStageBinding
import com.georgimirchev.serversiderenderedviews.databinding.ViewNowLiveBinding
import com.georgimirchev.serversiderenderedviews.events.ViewHolderEventsHandler

class ViewHolderMapper() {
    fun toViewHolder(
        parent: ViewGroup,
        viewType: Int,
        viewHolderEventsHandler: ViewHolderEventsHandler
    ): DynamicViewHolder<UiData, ViewBinding> {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ViewTypes.DETAILED_VIDEO_STAGE.value -> {
                val binding = ViewDetailedVideoStageBinding.inflate(layoutInflater, parent, false)
                DetailedVideoStageViewHolder(binding, viewHolderEventsHandler)
            }
            ViewTypes.NOW_LIVE_TV_COVERS.value -> {
                val binding = ViewNowLiveBinding.inflate(layoutInflater, parent, false)
                NowLiveCoverViewHolder(binding, viewHolderEventsHandler)
            }
            else -> {
                val binding = ViewDetailedVideoStageBinding.inflate(layoutInflater, parent, false)
                DetailedVideoStageViewHolder(binding, viewHolderEventsHandler)
            }
        } as DynamicViewHolder<in UiData, ViewBinding>
    }

    fun toViewType(uiData: UiData? = null) = when (uiData?.type) {
        UiDataTypes.DETAILED_VIDEO_STAGE -> ViewTypes.DETAILED_VIDEO_STAGE.value
        UiDataTypes.LIVE_TV -> ViewTypes.NOW_LIVE_TV_COVERS.value
        else -> 0
    }
}
