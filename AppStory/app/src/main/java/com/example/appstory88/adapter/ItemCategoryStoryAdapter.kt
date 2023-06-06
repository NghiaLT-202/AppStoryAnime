package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemCategoryStoryBinding
import com.example.appstory88.databinding.ItemTopStoryBinding
import com.example.appstory88.model.Story

class ItemCategoryStoryAdapter : BaseBindingAdapter<ItemCategoryStoryBinding>() {
    var listStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    var onItemClickListener: ItemClickListener? = null




    override fun onBindViewHolderBase(holder: BaseHolder<ItemCategoryStoryBinding>, position: Int) {
        val story:Story=listStory[position]
        holder.binding.tvNameCategory.text = story.nameCategory
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_category_story
    }

    override fun getSizeItem(): Int {
        return if (listStory.size > 10) {
            10
        } else {
            listStory.size
        }

    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}