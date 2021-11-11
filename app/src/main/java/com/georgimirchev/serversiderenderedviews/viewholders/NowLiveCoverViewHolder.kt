package com.georgimirchev.serversiderenderedviews.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import com.georgimirchev.domain.componentdata.types.LiveCoverUiData
import com.georgimirchev.serversiderenderedviews.databinding.ViewNowLiveBinding
import com.georgimirchev.serversiderenderedviews.events.ViewHolderEventsHandler

class NowLiveCoverViewHolder(
    viewNowLiveBinding: ViewNowLiveBinding,
    viewHolderEventsHandler: ViewHolderEventsHandler
) : DynamicViewHolder<LiveCoverUiData, ViewNowLiveBinding>(viewNowLiveBinding) {
    private val nowLiveCoverAdapter = NowLiveCoverAdapter()
    override fun bind(uiData: LiveCoverUiData) {
        with (binding.rvNowLive) {
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = nowLiveCoverAdapter
            val urls = uiData.data.values.map { it.map { it.images.first().url } }.flatten()
            nowLiveCoverAdapter.setItems(urls)
        }
    }
}
