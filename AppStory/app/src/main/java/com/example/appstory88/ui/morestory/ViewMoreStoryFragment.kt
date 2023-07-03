package com.example.appstory88.ui.morestory

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentShowMoreStoryBinding
import com.example.appstory88.data.model.Story
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.utils.StatusBarUtils
import com.google.gson.Gson

class ViewMoreStoryFragment :
    BaseBindingFragment<FragmentShowMoreStoryBinding, ViewMoreStoryModel>() {
    private var storyAdapter: StoryAdapter? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_show_more_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        StatusBarUtils.makeStatusBarLight(requireActivity(), ContextCompat.getColor(requireActivity(),R.color.white))

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
        mainViewModel.listStoryLiveData.observe(viewLifecycleOwner) {
            categoryJson?.let { it1 -> mainViewModel.initListStoryLiveData(it, it1) }
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
            binding.rcListStory.itemAnimator=null
            binding.rcListStory.adapter = this
            onItemClickListener = object : StoryAdapter.ItemClickListener {
                override fun onItemClick(story: Story, position: Int) {
                    navigateWithBundle(R.id.fragment_detail_story, Bundle().apply {
                        putString(
                            Constant.KEY_DETAIL_STORY,
                            Gson().toJson(story)
                        )
                    })                }
            }
        }

    }

}