package com.example.appstory88.ui.detailstory

import android.os.Bundle
import android.view.View
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant

import com.example.appstory88.databinding.FragmentRedStoryBinding
import com.example.appstory88.model.Story
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ReadStoryFragment :
    BaseBindingFragment<FragmentRedStoryBinding, ReadStoryViewModel>() {
    private var story: Story? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_red_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initListener()
        initData()

    }

    private fun initListener() {

        binding.imBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }




    override fun getViewModel(): Class<ReadStoryViewModel> {
        return ReadStoryViewModel::class.java
    }

    private fun initData() {
        val storyJson = arguments?.getString(Constant.KEY_DETAIL_STORY)
        story = Gson().fromJson<Story>(storyJson, object : TypeToken<Story>() {}.type)
        binding.tvNameStory.text = story?.nameStory
        binding.tvDescribeStory.text = story?.describe
        binding.tvNamechapter.text =getString(R.string.ch_ng)+ story?.chapter


    }
}