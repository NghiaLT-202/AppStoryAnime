package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemStoryBinding
import com.example.appstory88.model.Story

class StoryAdapter : BaseBindingAdapter<ItemStoryBinding>() {
    var listStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClickListener: ItemClickListener? = null


    override fun onBindViewHolderBase(holder: BaseHolder<ItemStoryBinding>, position: Int) {
        with(listStory[position]) {
            with(holder.binding) {
                Glide.with(holder.itemView.context).load(imageStory).into(imStory)
                tvNameStory.text = nameStory
                viewStar.numberStar = numberStar
                tvNameCategory.text = nameCategory[0]
            }
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(this, holder.adapterPosition)
            }
        }
    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_story
    }

    override fun getSizeItem(): Int {
        return if (listStory.size > 10) {
            10
        } else {
            listStory.size
        }

    }

    interface ItemClickListener {
        fun onItemClick(story: Story, position: Int)
    }
}