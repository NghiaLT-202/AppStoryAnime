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
        Glide.with(holder.itemView.context).load(story.imageStory).into(holder.binding.imStory)

        holder.binding.tvNameStory.text = story.nameStory

        holder.binding.tvView.text =
            holder.itemView.context.getString(R.string.view_number) + story.numberView.toString()
        holder.binding.viewStar.numberStar = story.numberStar
        when (position) {
            0 -> {
                holder.binding.tvView.setBackgroundResource(R.drawable.custom_bg_number_view_red)
            }

            1 -> {
                holder.binding.tvView.setBackgroundResource(R.drawable.custom_bg_number_view_blue)
            }

            2 -> {
                holder.binding.tvView.setBackgroundResource(R.drawable.custom_bg_number_view_violet)
            }

            else -> {
                holder.binding.tvView.setBackgroundResource(R.drawable.custom_bg_number_view)
            }
        }

//        holder.binding.tvView.background=drawable
//        holder.binding.view.setBackgroundColor(R.color.black)
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