package com.example.appstory88.ui.detailstory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.databinding.LayoutViewDetailStoryBinding
import com.example.appstory88.model.Story

class DetailStoryActivity : AppCompatActivity() {
    lateinit var binding: LayoutViewDetailStoryBinding
    private val listStory: MutableList<Story> = mutableListOf()
    lateinit var viewModel: DetailStoryViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.layout_view_detail_story)
        viewModel = ViewModelProvider(this)[DetailStoryViewModel::class.java]
        initData()





    }

    private fun initData() {
        viewModel.initData()
        viewModel.getAllListStory()

        viewModel.listStoryLiveData.observe(this) { story ->
            listStory.addAll(story)
            binding.tvNameStory.text = listStory[0].nameStory
            binding.tvContentStory.text = listStory[0].describe
            binding.tvNamechapter.text = "Chương 1 "
        }


    }
}