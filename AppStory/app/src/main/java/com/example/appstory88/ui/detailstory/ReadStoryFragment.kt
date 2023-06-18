package com.example.appstory88.ui.detailstory

import android.os.Bundle
import android.view.View
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentDetailStoryBinding
import com.example.appstory88.databinding.FragmentRedStoryBinding

class ReadStoryFragment :
    BaseBindingFragment<FragmentRedStoryBinding, ReadStoryViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_red_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initListener()
        initData()

    }

    private fun initListener() {
        binding.imBack.setOnClickListener {
            finish()
        }
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