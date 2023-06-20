package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemRateStoryBinding
import com.example.appstory88.model.Story

class RateStoryAdapter : BaseBindingAdapter<ItemRateStoryBinding>() {
    var listStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: ItemClickListener? = null


    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onBindViewHolderBase(holder: BaseHolder<ItemRateStoryBinding>, position: Int) {
        val story: Story = listStory[position]
       story.let {
           Glide.with(holder.itemView.context).load(it.imageStory).into(holder.binding.imStory)
           holder.binding.tvNameStory.text = it.nameStory
           holder.binding.tvView.text =
               holder.itemView.context.getString(R.string.view_number) + it.numberView.toString()
           holder.binding.viewStar.numberStar = it.numberStar
           holder.binding.tvView.setBackgroundResource(
               when (position) {
                   0 -> R.drawable.custom_bg_number_view_red
                   1 -> R.drawable.custom_bg_number_view_blue
                   2 -> R.drawable.custom_bg_number_view_violet
                   else -> R.drawable.custom_bg_number_view
               }
           )
       }
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }
    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_rate_story
    }

    override fun getSizeItem(): Int {
        return listStory.size


    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}