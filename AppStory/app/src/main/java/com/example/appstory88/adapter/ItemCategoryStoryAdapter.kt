package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemCategoryStoryBinding
import com.example.appstory88.databinding.ItemTopStoryBinding
import com.example.appstory88.model.Story

class ItemCategoryStoryAdapter : BaseBindingAdapter<ItemCategoryStoryBinding>() {
    private val listStory: MutableList<Story> = arrayListOf()
    var onItemClickListener: ItemClickListener? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setListStory(lisSing: MutableList<Story>?) {
        this.listStory.clear()
        this.listStory.addAll(lisSing!!)
        notifyDataSetChanged()
    }



    override fun onBindViewHolderBase(holder: BaseHolder<ItemCategoryStoryBinding>, position: Int) {
        holder.binding.tvNameCategory.text = listStory[position].nameCategory
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_category_story
    }

    override fun getSizeItem(): Int {
        if (listStory.size > 10) {
            return 10
        } else {
            return listStory.size
        }

    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}