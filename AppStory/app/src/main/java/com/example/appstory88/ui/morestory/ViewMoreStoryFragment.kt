package com.example.appstory88.ui.morestory

import android.os.Bundle
import android.view.View
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentShowMoreStoryBinding
import com.example.appstory88.model.Story

class ViewMoreStoryFragment :
    BaseBindingFragment<FragmentShowMoreStoryBinding, ViewMoreStoryModel>() {
    private var storyAdapter: StoryAdapter? = null
    private var listStory: MutableList<Story> = mutableListOf()
    override fun getLayoutId(): Int {
        return R.layout.fragment_show_more_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initListener()
        initAdapter()
        setupData()
    }

    private fun initListener() {
        binding.imBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }


    fun setupData() {
        val category = arguments?.getString(Constant.CATEGORY_STORY) ?: ""
        binding.nameCategory.text = category
        mainViewModel.initData(requireContext())
        mainViewModel.listStoryLiveData.observe(this) { story ->
            listStory.clear()
            listStory.addAll(story)
            mainViewModel.initlistStoryLiveData(listStory, category)
            storyAdapter?.listStory = listStory
        }
    }


    override fun getViewModel(): Class<ViewMoreStoryModel> {
        return ViewMoreStoryModel::class.java
    }


    private fun initAdapter() {
        storyAdapter = StoryAdapter().apply {
            binding.rcListStory.adapter = this
            onItemClickListener = object : StoryAdapter.ItemClickListener {
                override fun onItemClick(story: Story, position: Int) {
//                    intentActivityAndData(story)
                }
            }
        }

    }

//    private fun intentActivityAndData(story: Story) {
//
//
//    }
}