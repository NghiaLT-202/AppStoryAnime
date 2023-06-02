package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemStoryBannerBinding
import com.example.appstory88.model.Story

class StoryBanerAdapter: BaseBindingAdapter<ItemStoryBannerBinding>() {
    private val listStory: MutableList<Story> = arrayListOf()
     var iclick:Iclick?=null
    @SuppressLint("NotifyDataSetChanged")
    fun setListStoryBanner(lisSing: MutableList<Story>?) {
        this.listStory.clear()
        this.listStory.addAll(lisSing!!)
        notifyDataSetChanged()
    }

    override fun onBindViewHolderBase(holder: BaseHolder<ItemStoryBannerBinding>, position: Int) {
        holder.binding.imStory.setImageResource(listStory[position].imageStory)
        holder.binding.tvNameStory.text=listStory[position].nameStory
        holder.binding.tvValueNameAuthor.text=listStory[position].nameAuthur
        holder.binding.tvValueNameCategory.text=listStory[position].nameCategory
        holder.binding.viewStar.numberStar=listStory[position].numberStar
        holder.itemView.setOnClickListener {
            iclick?.clickItem(holder.adapterPosition)

        }

    }

    override fun getLayoutIdItem(): Int {
        return R.layout.item_story_banner
    }

    override fun getSizeItem(): Int {
       return listStory.size
    }
    interface Iclick{
     fun   clickItem(position: Int)
    }

}