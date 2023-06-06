package com.example.appstory88.ui.detailstory

import android.os.Bundle
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.ActivityDetailStoryBinding


class ReadStoryActivity :
    BaseBindingActivity<ActivityDetailStoryBinding, ReadStoryViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_detail_story
    }

    override fun setupView(savedInstanceState: Bundle?) {
        binding.imBack.setOnClickListener {
            finish()
        }

    }

    override fun setupData() {
        initData()
    }

    override fun getViewModel(): Class<ReadStoryViewModel> {
        return ReadStoryViewModel::class.java
    }

    private fun initData() {
        binding.tvNameStory.text = intent.getStringExtra(Constant.NAME_STORY)
        binding.tvDescribeStory.text = intent.getStringExtra(Constant.DESCRIBE_STORY)
        binding.tvNamechapter.text = intent.getStringExtra(Constant.CHAPTER_STORY)


    }
}