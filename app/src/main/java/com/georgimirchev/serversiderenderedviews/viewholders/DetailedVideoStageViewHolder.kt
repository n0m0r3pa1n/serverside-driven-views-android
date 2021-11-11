package com.georgimirchev.serversiderenderedviews.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.georgimirchev.domain.componentdata.UiComponentData
import com.georgimirchev.serversiderenderedviews.R
import com.georgimirchev.serversiderenderedviews.databinding.ViewDetailedVideoStageBinding
import com.georgimirchev.serversiderenderedviews.events.ClickEvent
import com.georgimirchev.serversiderenderedviews.events.ViewHolderEventsHandler

class DetailedVideoStageViewHolder(
    private val detailedVideoStageBinding: ViewDetailedVideoStageBinding,
    viewHolderEventsHandler: ViewHolderEventsHandler
) : DynamicViewHolder(detailedVideoStageBinding.root) {
    init {
        detailedVideoStageBinding.tvTitle.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                viewHolderEventsHandler.submitEvent(ClickEvent(R.id.tv_title))
            }
        }
    }

    override fun bind(uiData: UiComponentData) {
        detailedVideoStageBinding.tvTitle.text = uiData.type
    }
}
