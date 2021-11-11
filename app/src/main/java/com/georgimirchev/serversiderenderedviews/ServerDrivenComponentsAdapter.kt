package com.georgimirchev.serversiderenderedviews

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.georgimirchev.domain.componentdata.UiData
import com.georgimirchev.domain.uievents.UiEvent
import com.georgimirchev.serversiderenderedviews.events.ViewHolderEventsHandler
import com.georgimirchev.serversiderenderedviews.viewholders.DynamicViewHolder
import com.georgimirchev.serversiderenderedviews.viewholders.ViewHolderMapper
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class ServerDrivenComponentsAdapter(
    private val viewHolderMapper: ViewHolderMapper
) : RecyclerView.Adapter<DynamicViewHolder<UiData, ViewBinding>>(), ViewHolderEventsHandler {
    private var items: List<UiData>? = null

    private val _uiEvents = MutableSharedFlow<UiEvent>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val uiEvents: Flow<UiEvent> = _uiEvents

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DynamicViewHolder<UiData, ViewBinding> {
        return viewHolderMapper.toViewHolder(parent, viewType, this)
    }

    override fun onBindViewHolder(holder: DynamicViewHolder<UiData, ViewBinding>, position: Int) {
        items?.let { holder.bind(it[position]) }
    }

    override fun getItemViewType(position: Int) = viewHolderMapper.toViewType(items?.get(position))

    override fun getItemCount(): Int = items?.size ?: 0

    fun setItems(items: List<UiData>) {
        this.items = items
        notifyItemRangeChanged(0, items.size)
    }

    override fun submitEvent(uiEvent: UiEvent) {
        _uiEvents.tryEmit(uiEvent)
    }
}
