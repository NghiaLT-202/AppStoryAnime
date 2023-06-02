package com.example.appstory88.ui.detailstory

import android.content.Intent
import android.os.Bundle
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.LayoutViewDetailStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.ui.describestory.ViewDescribeStoryActivity

class DetailStoryActivity :
    BaseBindingActivity<LayoutViewDetailStoryBinding, DetailStoryViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()


    override fun getLayoutId(): Int {
        return R.layout.layout_view_detail_story
    }

    override fun setupView(savedInstanceState: Bundle?) {
        binding.imBack.setOnClickListener {
            finish()
        }

    }

    override fun setupData() {
        initData()
    }

    override fun getViewModel(): Class<DetailStoryViewModel> {
        return DetailStoryViewModel::class.java
    }

    private fun initData() {
        binding.tvNameStory.text = intent.getStringExtra(Constant.NAME_STORY)
        binding.tvDescribeStory.text = intent.getStringExtra(Constant.DESCRIBE_STORY)
        binding.tvNamechapter.text = intent.getStringExtra(Constant.CHAPTER_STORY)


    }
}