package com.andriod.sharedelementanimation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.andriod.sharedelementanimation.databinding.ItemImageBinding

class RecyclerAdapter(val listener: Listener) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var images = ImageData.IMAGE_DRAWABLES

    interface Listener {
        fun onClick(imageId: Int, view: View)
        fun onStartPostponedEnterTransition()
    }

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(ItemImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false).root) {

        var currentImageId: Int? = null

        private val binding = ItemImageBinding.bind(itemView).apply {
            imageView.setOnClickListener {
                listener.onClick(currentImageId ?: 0, imageView)
            }
        }

        fun bind(imageId: Int) {
            binding.imageView.apply {
                currentImageId = imageId
                setImageDrawable(AppCompatResources.getDrawable(context, imageId))
                transitionName = imageId.toString()
                if (currentImageId == imageId)
                    listener.onStartPostponedEnterTransition()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(images[position])
    override fun getItemCount() = images.size
}