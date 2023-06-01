package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemRateStoryBinding
import com.example.appstory88.model.Story

class RateStoryAdapter : BaseBindingAdapter<ItemRateStoryBinding>() {
    private val listStory: ArrayList<Story> = ArrayList<Story>()
    lateinit var onItemClickListener: ItemClickListener


    @SuppressLint("NotifyDataSetChanged")
    fun setListStory(lisSing: List<Story>?) {
        this.listStory.clear()
        this.listStory.addAll(lisSing!!)
        notifyDataSetChanged()
    }


    override fun onBindViewHolderBase(holder: BaseHolder<ItemRateStoryBinding>, position: Int) {
        holder.binding.imStory.setImageResource(listStory[position].imageStory)
        holder.binding.tvNameStory.text = listStory[position].nameStory
        holder.binding.tvNumberView.text = listStory[position].numberView.toString()
        holder.binding.viewStar.numberStar = listStory[position].numberStar
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(holder.adapterPosition)
        }
    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_rate_story
    }

    override fun getSizeItem(): Int {
        if (listStory.size > 10) {
            return 10
        } else {
            return listStory.size
        }

    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}