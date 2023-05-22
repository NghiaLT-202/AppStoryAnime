package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemStoryBinding
import com.example.appstory88.model.Story

class StoryAdapter : BaseBindingAdapter<ItemStoryBinding>() {
    private val listStory: ArrayList<Story> = ArrayList<Story>()
    private lateinit var onItemClickListener: ItemClickListener


    @SuppressLint("NotifyDataSetChanged")
    fun setListStory(lisSing: List<Story>?) {
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
            onItemClickListener.onItemClick(holder.adapterPosition)

        }
    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_story
    }

    override fun getSizeItem(): Int {
        return listStory.size
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}