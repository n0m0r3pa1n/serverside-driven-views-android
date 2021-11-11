package com.georgimirchev.serversiderenderedviews.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.georgimirchev.serversiderenderedviews.databinding.ItemNowLiveCoverBinding
import com.georgimirchev.serversiderenderedviews.events.LiveCoverClickEvent
import com.georgimirchev.serversiderenderedviews.events.ViewHolderEventsHandler
import timber.log.Timber

class NowLiveCoverAdapter(private val viewHolderEventsHandler: ViewHolderEventsHandler) : RecyclerView.Adapter<NowLiveCoverAdapter.ViewHolder>() {
    private var imageUrls: List<Pair<String, String>> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNowLiveCoverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ViewHolder(binding)
        binding.cover.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                viewHolderEventsHandler.submitEvent(LiveCoverClickEvent(imageUrls[adapterPosition].first))
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imageUrls[position].second)
    }

    override fun getItemCount(): Int = imageUrls.size

    fun setItems(imageUrls: List<Pair<String, String>>) {
        this.imageUrls = imageUrls
        notifyItemRangeChanged(0, imageUrls.size)
    }

    class ViewHolder(
        val binding: ItemNowLiveCoverBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            Timber.d("### $url")
            Glide.with(binding.root.context)
                .load("https://cdn.shopify.com/s/files/1/1061/1924/products/Dog_Emoji_grande.png")
                .into(binding.cover)
        }
    }
}
