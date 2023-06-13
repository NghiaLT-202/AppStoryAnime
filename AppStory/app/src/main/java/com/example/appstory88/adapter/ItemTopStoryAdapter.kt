package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemTopStoryBinding
import com.example.appstory88.model.Story

class ItemTopStoryAdapter : BaseBindingAdapter<ItemTopStoryBinding>() {
     var listStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    var onItemClickListener: ItemClickListener? = null
    override fun onBindViewHolderBase(holder: BaseHolder<ItemTopStoryBinding>, position: Int) {
        val story:Story= listStory[position]

        holder.binding.tvNameCategory.text = story.nameCategory
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }
    }
    override fun getLayoutIdItem(): Int {
        return R.layout.item_top_story
    }

    override fun getSizeItem(): Int {

            return listStory.size


    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}