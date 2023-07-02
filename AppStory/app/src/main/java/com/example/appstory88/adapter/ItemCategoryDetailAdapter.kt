package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemCategoryDetailBinding
import com.example.appstory88.data.model.Story

class ItemCategoryDetailAdapter : BaseBindingAdapter<ItemCategoryDetailBinding>() {
    var listCategoryStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged") set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: ItemClickListener? = null


    override fun onBindViewHolderBase(
        holder: BaseHolder<ItemCategoryDetailBinding>, position: Int
    ) {
        with(listCategoryStory[position]) {
            holder.binding.tvValueCategory.text = nameCategory[0]
        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }

    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_category_detail
    }

    override fun getSizeItem(): Int {
        return if (listCategoryStory.size > 10) {
            10
        } else {
            listCategoryStory.size
        }

    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}