package com.example.appstory88.adapter

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingAdapter
import com.example.appstory88.databinding.ItemStoryBookmarkBinding
import com.example.appstory88.model.Story

class StoryBookmarkAdapter : BaseBindingAdapter<ItemStoryBookmarkBinding>() {
    var listStory: MutableList<Story> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")

        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var iclick: IClick? = null



    override fun onBindViewHolderBase(holder: BaseHolder<ItemStoryBookmarkBinding>, position: Int) {
        with(listStory[position]) {
            with(holder.binding) {
                imStory.post { Glide.with(holder.itemView.context).asBitmap().load(imageStory).into(imStory) }
                tvNameStory.text = nameStory
                tvValueNameAuthor.text = nameAuthur
                tvValueTotalChapter.text = chapterSum.toString()
//                viewStar.numberStar = numberStar
            }
            holder.itemView.setOnClickListener {
                iclick?.clickItem(this, holder.adapterPosition)
            }
        }    }

    override fun getLayoutIdItem(): Int {
        return R.layout.item_story_bookmark
    }

    override fun getSizeItem(): Int {
        return listStory.size
    }

    interface IClick {
        fun clickItem(story: Story, position: Int)
    }

}