package com.example.appstory88.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import androidx.core.view.isVisible
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

        with(listCategory[position]) {
            val color = Color.parseColor(color)
            if (sumStory>0){
                with(holder.binding) {
                    tvName.text = name
                    cvLineVertical.visibility=View.VISIBLE
                    viewLineVertical.visibility= View.VISIBLE
                    viewBackground.visibility= View.VISIBLE

                    viewLineVertical.setBackgroundColor(color)
                    viewBackground.setBackgroundColor(color)
                    tvName.setTextColor(color)
                    tvSumStory.text =
                        sumStory.toString() + " " + holder.itemView.context.getString(R.string.truyen)
                }
            }


        }
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