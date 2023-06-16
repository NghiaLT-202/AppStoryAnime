package com.example.appstory88.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemRateStoryBinding
import com.example.appstory88.model.Story

class RateStoryAdapter : BaseBindingAdapter<ItemRateStoryBinding>() {
    var listStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field=value
            notifyDataSetChanged()
        }
     var onItemClickListener: ItemClickListener?=null





    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolderBase(holder: BaseHolder<ItemRateStoryBinding>, position: Int) {
        val story:Story= listStory[position]
        holder.binding.imStory.setImageResource( story.imageStory)
        holder.binding.tvNameStory.text =  story.nameStory
        holder.binding.tvNumberView.text =  story.numberView.toString()
        holder.binding.viewStar.numberStar =  story.numberStar
        when (position) {
            0 -> {
                holder.binding.view.setBackgroundColor(Color.parseColor("#B8545F"))
            }

            1 -> {
                holder.binding.view.setBackgroundColor(Color.parseColor("#4C6699"))
            }

            2 -> {
                holder.binding.view.setBackgroundColor(Color.parseColor("#7A3A80"))
            }

            else -> {
                holder.binding.view.setBackgroundColor(Color.parseColor("#9B9B9B"))
            }
        }

//        holder.binding.tvView.background=drawable
//        holder.binding.view.setBackgroundColor(R.color.black)
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
        }
    }


    override fun getLayoutIdItem(): Int {
        return R.layout.item_rate_story
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