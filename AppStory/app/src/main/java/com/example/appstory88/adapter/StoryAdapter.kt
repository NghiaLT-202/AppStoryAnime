package com.example.appstory88.adapter

import android.annotation.SuppressLint
import android.util.Log
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemStoryBinding
import com.example.appstory88.model.Story

class StoryAdapter : BaseBindingAdapter<ItemStoryBinding>() {
    private val listStory: MutableList<Story> = arrayListOf()
     var onItemClickListener: ItemClickListener?=null


    @SuppressLint("NotifyDataSetChanged")
    fun setListStory(lisSing: MutableList<Story>?) {
        this.listStory.clear()
        this.listStory.addAll(lisSing!!)
        notifyDataSetChanged()
    }
    override fun onBindViewHolderBase(holder: BaseHolder<ItemStoryBinding>, position: Int) {
        holder.binding.imStory.setImageResource(listStory[position].imageStory)
        holder.binding.tvNameStory.text = listStory[position].nameStory
        holder.binding.viewStar.numberStar = listStory[position].numberStar

        holder.binding.tvNameCategory.text = listStory[position].nameCategory
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }
    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_story
    }

    override fun getSizeItem(): Int {
        return if(listStory.size>10){
            10
        } else{
            listStory.size
        }

    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}