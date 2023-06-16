package com.example.appstory88.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appstory88.databinding.ItemStoryBinding
import com.example.appstory88.model.Story


class ListStoryPreviewAdapter : Adapter<ListStoryPreviewAdapter.ListStoryPreviewHolder>() {

    var listStory: MutableList<Story> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ListStoryPreviewHolder(var binding: ItemStoryBinding) :
        ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListStoryPreviewHolder {
        val binding = ItemStoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ListStoryPreviewHolder(binding)

    }

    override fun getItemCount(): Int {
        return listStory.size
    }

    override fun onBindViewHolder(holder: ListStoryPreviewHolder, position: Int) {
        val story = listStory[position]
        holder.binding.imStory.setImageResource(story.imageStory)
        holder.binding.tvNameStory.text = story.nameStory
        holder.binding.tvNameCategory.text = story.nameCategory
        holder.binding.viewStar.numberStar = story.numberStar
    }
}