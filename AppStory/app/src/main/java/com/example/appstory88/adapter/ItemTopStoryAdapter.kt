package com.example.appstory88.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemTopStoryBinding
import com.example.appstory88.model.ItemTopStory

class ItemTopStoryAdapter : BaseBindingAdapter<ItemTopStoryBinding>() {
    var listStory: MutableList<ItemTopStory> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: ItemClickListener? = null
    override fun onBindViewHolderBase(holder: BaseHolder<ItemTopStoryBinding>, position: Int) {
        with(listStory[position]){
            val color = Color.parseColor(color)
            holder.binding.tvName.text = name
            holder.binding.viewLineVertical.setBackgroundColor(color)
            holder.binding.viewBackground.setBackgroundColor(color)
            holder.binding.tvName.setTextColor(color)
        }

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