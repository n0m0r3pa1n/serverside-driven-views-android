package com.georgimirchev.serversiderenderedviews.viewholders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.georgimirchev.domain.componentdata.UiComponentData
import com.georgimirchev.domain.componentdata.types.UiComponentDataTypes
import com.georgimirchev.serversiderenderedviews.databinding.ViewDetailedVideoStageBinding
import com.georgimirchev.serversiderenderedviews.events.ViewHolderEventsHandler

class ViewHolderMapper(context: Context) {
    private val layoutInflater = LayoutInflater.from(context)

    fun toViewHolder(
        parent: ViewGroup,
        viewType: Int,
        viewHolderEventsHandler: ViewHolderEventsHandler
    ): DynamicViewHolder = when (viewType) {
        ViewTypes.DETAILED_VIDEO_STAGE.value -> {
            val binding = ViewDetailedVideoStageBinding.inflate(layoutInflater, parent, false)
            DetailedVideoStageViewHolder(binding, viewHolderEventsHandler)
        }

        else -> {
            val binding = ViewDetailedVideoStageBinding.inflate(layoutInflater, parent, false)
            DetailedVideoStageViewHolder(binding, viewHolderEventsHandler)
        }
    }

    fun toViewType(uiData: UiComponentData? = null) = when (uiData?.type) {
        UiComponentDataTypes.DETAILED_VIDEO_STAGE -> ViewTypes.DETAILED_VIDEO_STAGE.value
        else -> 0
    }
}
