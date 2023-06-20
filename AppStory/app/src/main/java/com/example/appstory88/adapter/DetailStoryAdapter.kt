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
    var onItemClickListener: ItemClickListener? = null


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolderBase(holder: BaseHolder<ItemDetailStoryBinding>, position: Int) {
        val story: Story = listStory[position]
        val tvChapterSum = holder.itemView.context.getString(R.string.chapter_sum)
        story.let {
            Glide.with(holder.itemView.context).load(it.imageStory).into(holder.binding.imStory)
            holder.binding.tvNameStory.text = it.nameStory
            holder.binding.tvNumberChapter.text = tvChapterSum + it.chapterSum.toString()
            holder.binding.tvNameCategory.text = it.nameCategory
            holder.binding.viewStar.numberStar = it.numberStar
        }

        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(story, holder.adapterPosition)
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