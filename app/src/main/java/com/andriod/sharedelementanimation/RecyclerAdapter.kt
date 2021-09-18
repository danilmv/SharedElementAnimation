package com.andriod.sharedelementanimation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andriod.sharedelementanimation.databinding.ItemImageBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var images = ImageData.IMAGE_DRAWABLES

    class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(ItemImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false).root) {

        val binding = ItemImageBinding.bind(itemView)

        fun bind(drawable: Int) {
            binding.imageView.apply {
                setImageDrawable(resources.getDrawable(drawable, context.theme))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(images[position])
    override fun getItemCount() = images.size
}