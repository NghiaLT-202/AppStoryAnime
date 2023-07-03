package com.example.appstory88.ui.home.topstory

import android.os.Bundle
import android.view.View
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemTopStoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.data.model.ItemTopStory
import com.example.appstory88.databinding.FragmentTopStoryBinding

class TopStoryFragment : BaseBindingFragment<FragmentTopStoryBinding, TopStoryViewModel>() {
    private val listStory: MutableList<ItemTopStory> = mutableListOf()
    private var itemTopStoryAdapter: ItemTopStoryAdapter? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_top_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initListener()
        initAdapter()
        setupData()
    }

    private fun initListener() {


    }

    fun setupData() {
        mainViewModel.initDataTopStory(requireContext())
        mainViewModel.listTopStoryLiveData.observe(viewLifecycleOwner) {
            listStory.clear()
            listStory.addAll(it)
            itemTopStoryAdapter?.listStory = it
        }
    }

    private fun initAdapter() {
        itemTopStoryAdapter = ItemTopStoryAdapter().apply {
            binding.rcItemStory.itemAnimator = null

            binding.rcItemStory.adapter = this
            onItemClickListener = object : ItemTopStoryAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                    navigateWithBundle(
                        R.id.fragment_detail_story_top,
                        Bundle().apply {
                            putString(
                                Constant.CATEGORY_STORY,
                                listStory[position].name
                            )
                        })

                }
            }
        }
    }

    override fun getViewModel(): Class<TopStoryViewModel> {
        return TopStoryViewModel::class.java
    }


}