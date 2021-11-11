package com.georgimirchev.serversiderenderedviews.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.georgimirchev.serversiderenderedviews.databinding.ItemNowLiveCoverBinding
import timber.log.Timber

class NowLiveCoverAdapter: RecyclerView.Adapter<NowLiveCoverAdapter.ViewHolder>() {
    private var imageUrls: List<String> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNowLiveCoverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imageUrls[position])
    }

    override fun getItemCount(): Int = imageUrls.size

    fun setItems(imageUrls: List<String>) {
        this.imageUrls = imageUrls
        notifyItemRangeChanged(0, imageUrls.size)
    }

    class ViewHolder(val binding: ItemNowLiveCoverBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            Timber.d("### $url")
            Glide.with(binding.root.context)
                .load("https://cdn.shopify.com/s/files/1/1061/1924/products/Dog_Emoji_grande.png")
                .into(binding.cover)
        }
    }
}
