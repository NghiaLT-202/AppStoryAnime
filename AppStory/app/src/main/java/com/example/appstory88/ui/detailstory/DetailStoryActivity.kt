package com.example.appstory88.ui.detailstory

import android.os.Bundle
import android.util.Log
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.LayoutViewDetailStoryBinding
import com.example.appstory88.model.Story

class DetailStoryActivity :
    BaseBindingActivity<LayoutViewDetailStoryBinding, DetailStoryViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()


    override fun getLayoutId(): Int {
       return R.layout.layout_view_detail_story
    }

    override fun setupView(savedInstanceState: Bundle?) {


    }

    override fun setupData() {
        initData()
    }

    override fun getViewModel(): Class<DetailStoryViewModel> {
        return DetailStoryViewModel::class.java
    }

    private fun initData() {
        Log.e("tnghia",""+listStory.size    )
        binding.tvNameStory.text=intent.getStringExtra("nameStory")
        binding.tvDescribeStory.text=intent.getStringExtra("describeStory")
        binding.tvNamechapter.text=intent.getStringExtra("chapter")


    }
}