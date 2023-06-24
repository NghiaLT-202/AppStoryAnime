package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemDetailStoryBinding
import com.example.appstory88.model.Story

class DetailStoryAdapter : BaseBindingAdapter<ItemDetailStoryBinding>() {
    var listStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    // khai báo interface
    var onItemClickListener: ItemClickListener? = null


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolderBase(holder: BaseHolder<ItemDetailStoryBinding>, position: Int) {
        with(listStory[position]) {
            with(holder.binding) {
                holder.itemView.context.let {
                    Glide.with(it).load(imageStory).into(imStory)
                    tvNumberChapter.text = it.getString(R.string.chapter_sum) + chapterSum
                }
                tvNameStory.text = nameStory
                tvNameCategory.text = nameCategory
                viewStar.numberStar = numberStar
            }
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(this, holder.adapterPosition)
            }
        }
    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_detail_story
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