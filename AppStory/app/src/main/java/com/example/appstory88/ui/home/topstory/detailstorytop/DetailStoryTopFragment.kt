package com.example.appstory88.ui.home.topstory.detailstorytop

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.DetailStoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentDetailStoryTopBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.ui.MainViewModel
import com.google.gson.Gson

class DetailStoryTopFragment :
    BaseBindingFragment<FragmentDetailStoryTopBinding, DetailStoryTopViewModel>() {
    private var detailStoryAdapter: DetailStoryAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail_story_top
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {

        setupViews()
        setupData()
    }

    private fun setupViews() {
        initAdapter()
    }

    private fun setupData() {
        val category = arguments?.getString(Constant.CATEGORY_STORY) ?: ""
        binding.tvNameCategory.text = category
        mainViewModel.listStoryLiveData.observe(viewLifecycleOwner) {
            mainViewModel.initlistDetailStoryLiveData(it, category)

        }
        mainViewModel.listStoryDetailLiveData.observe(viewLifecycleOwner) {
            detailStoryAdapter?.listStory = it

        }
    }

    override fun getViewModel(): Class<DetailStoryTopViewModel> {
        return DetailStoryTopViewModel::class.java
    }

    private fun initAdapter() {
        detailStoryAdapter = DetailStoryAdapter().apply {
            binding.rcItemStory.adapter = this
            onItemClickListener = object : DetailStoryAdapter.ItemClickListener {
                override fun onItemClick(story: Story, position: Int) {
                    intentActivityAndData(story)
                }
            }

        }
    }

    private fun intentActivityAndData(story: Story) {
        story.let {
           Bundle().let {
               it.putString(
                   Constant.KEY_DETAIL_STORY,
                   Gson().toJson(story)
               )
               (requireActivity() as MainActivity).navController?.navigate(
                   R.id.fragment_detail_story,
                   it
               )
           }

        }


    }

}