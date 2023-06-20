package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemCategoryDetailBinding
import com.example.appstory88.model.Story

class ItemCategoryDetailAdapter : BaseBindingAdapter<ItemCategoryDetailBinding>() {
    var listCategoryStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged") set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: ItemClickListener? = null


    override fun onBindViewHolderBase(
        holder: BaseHolder<ItemCategoryDetailBinding>,
        position: Int
    ) {
        val story: Story = listCategoryStory[position]
        story.let {
            holder.binding.tvValueCategory.text = it.nameCategory

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