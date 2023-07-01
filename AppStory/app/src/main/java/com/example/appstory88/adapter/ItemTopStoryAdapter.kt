package com.example.appstory88.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemTopStoryBinding
import com.example.appstory88.model.ItemTopStory
import timber.log.Timber

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
            val color= try {
                Color.parseColor(color.toString())

            } catch (e: IllegalArgumentException) {
               Timber.e(e)
                Color.parseColor("#000000")
            }
            with( holder.binding){
                tvName.text = name
                viewLineVertical.setBackgroundColor(color)
                viewBackground.setBackgroundColor(color)
                tvName.setTextColor(color)
            }


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