package com.example.appstory88.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
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





    override fun onBindViewHolderBase(holder: BaseHolder<ItemRateStoryBinding>, position: Int) {
//        val context:Context
        val story:Story= listStory[position]
        val drawable = GradientDrawable()

//        drawable.setColor(ContextCompat.getColor( R.color.black))


        holder.binding.imStory.setImageResource( story.imageStory)
        holder.binding.tvNameStory.text =  story.nameStory
        holder.binding.tvNumberView.text =  story.numberView.toString()
        holder.binding.viewStar.numberStar =  story.numberStar
//        holder.binding.view.
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(holder.adapterPosition)
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