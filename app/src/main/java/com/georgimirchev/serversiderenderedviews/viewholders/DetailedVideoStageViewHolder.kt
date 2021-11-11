package com.georgimirchev.serversiderenderedviews.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.georgimirchev.domain.componentdata.types.DetailedVideoStageUiData
import com.georgimirchev.serversiderenderedviews.R
import com.georgimirchev.serversiderenderedviews.databinding.ViewDetailedVideoStageBinding
import com.georgimirchev.serversiderenderedviews.events.ClickEvent
import com.georgimirchev.serversiderenderedviews.events.ViewHolderEventsHandler

class DetailedVideoStageViewHolder(
    detailedVideoStageBinding: ViewDetailedVideoStageBinding,
    viewHolderEventsHandler: ViewHolderEventsHandler
) : DynamicViewHolder<DetailedVideoStageUiData, ViewDetailedVideoStageBinding>(detailedVideoStageBinding) {
    init {
        binding.tvTitle.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                viewHolderEventsHandler.submitEvent(ClickEvent(R.id.tv_title))
            }
        }
    }

    override fun bind(uiData: DetailedVideoStageUiData) {
        binding.tvTitle.text = uiData.type
    }
}
