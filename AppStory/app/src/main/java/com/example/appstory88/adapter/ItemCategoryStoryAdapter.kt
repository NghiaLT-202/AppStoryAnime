package com.example.appstory88.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemCategoryStoryBinding
import com.example.appstory88.model.ItemCategory

class ItemCategoryStoryAdapter : BaseBindingAdapter<ItemCategoryStoryBinding>() {
    var listCategory: MutableList<ItemCategory> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: ItemClickListener? = null


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolderBase(holder: BaseHolder<ItemCategoryStoryBinding>, position: Int) {
        val category = listCategory[position]
        holder.binding.tvName.text = category.name
        val color = Color.parseColor(category.color)
        holder.binding.viewLineVertical.setBackgroundColor(color)
        holder.binding.viewBackground.setBackgroundColor(color)
        holder.binding.tvName.setTextColor(color)
        holder.binding.tvSumStory.text =
            category.sumStory.toString() + " " + holder.itemView.context.getString(R.string.truyen)
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }
    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_category_story
    }

    override fun getSizeItem(): Int {
        return listCategory.size

    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}