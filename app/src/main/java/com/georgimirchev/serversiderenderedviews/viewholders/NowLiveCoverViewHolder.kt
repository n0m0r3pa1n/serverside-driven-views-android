package com.georgimirchev.serversiderenderedviews.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import com.georgimirchev.domain.componentdata.types.LiveCoverUiData
import com.georgimirchev.serversiderenderedviews.databinding.ViewNowLiveBinding
import com.georgimirchev.serversiderenderedviews.events.ViewHolderEventsHandler

class NowLiveCoverViewHolder(
    viewNowLiveBinding: ViewNowLiveBinding,
    viewHolderEventsHandler: ViewHolderEventsHandler
) : DynamicViewHolder<LiveCoverUiData, ViewNowLiveBinding>(viewNowLiveBinding) {
    private val nowLiveCoverAdapter = NowLiveCoverAdapter(viewHolderEventsHandler)
    override fun bind(uiData: LiveCoverUiData) {
        with (binding.rvNowLive) {
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = nowLiveCoverAdapter
            val urls = uiData.data.values.flatten().map {
                it.channelId.toString() to (it.images.firstOrNull()?.url ?: "")
            }
            nowLiveCoverAdapter.setItems(urls)
        }
    }
}
