package com.example.appstory88.ui.morestory

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentShowMoreStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainActivity
import com.google.gson.Gson
import timber.log.Timber

class ViewMoreStoryFragment :
    BaseBindingFragment<FragmentShowMoreStoryBinding, ViewMoreStoryModel>() {
    private var storyAdapter: StoryAdapter? = null
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
        val categoryJson = arguments?.getString(Constant.CATEGORY_STORY)
        binding.nameCategory.text=categoryJson
        mainViewModel.listStoryLiveData.observe(viewLifecycleOwner) {
            categoryJson?.let { it1 -> mainViewModel.initlistStoryLiveData(it, it1) }
        }
        mainViewModel.listStoryMoreLiveData.observe(viewLifecycleOwner){
            storyAdapter?.listStory = it


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
                    intentActivityAndData(story)
                }
            }
        }

    }
    private fun intentActivityAndData(story: Story) {
        (requireActivity() as MainActivity).navController?.navigate(
            R.id.fragment_detail_story,
            Bundle().apply {
                putString(
                    Constant.KEY_DETAIL_STORY,
                    Gson().toJson(story)
                )
            }
        )
    }
}