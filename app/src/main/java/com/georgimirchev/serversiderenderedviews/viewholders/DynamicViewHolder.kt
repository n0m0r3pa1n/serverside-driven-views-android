package com.georgimirchev.serversiderenderedviews.viewholders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.georgimirchev.domain.componentdata.UiData

abstract class DynamicViewHolder<in T: UiData, out R: ViewBinding>(val binding: R) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(uiData: T)
}
