package com.example.appstory88.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemDetailStoryBinding
import com.example.appstory88.databinding.ItemRateStoryBinding
import com.example.appstory88.model.Story

class DetailStoryAdapter : BaseBindingAdapter<ItemDetailStoryBinding>() {
    var listStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field=value
            notifyDataSetChanged()
        }
     var onItemClickListener: ItemClickListener?=null






    override fun onBindViewHolderBase(holder: BaseHolder<ItemDetailStoryBinding>, position: Int) {
        val story:Story= listStory[position]
        val tvChapterSum="Chapter sum: "
        holder.binding.imStory.setImageResource( story.imageStory)
        holder.binding.tvNameStory.text =  story.nameStory
        holder.binding.tvNumberChapter.text =  tvChapterSum+story.chapterSum.toString()
        holder.binding.tvNameCategory.text =  story.nameCategory
        holder.binding.viewStar.numberStar =  story.numberStar
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }    }


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
        fun onItemClick(position: Int)
    }
}