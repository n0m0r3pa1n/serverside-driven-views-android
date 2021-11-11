package com.georgimirchev.serversiderenderedviews.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.georgimirchev.domain.componentdata.UiComponentData

abstract class DynamicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(uiData: UiComponentData)
}
