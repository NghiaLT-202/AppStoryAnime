package com.example.appstory88.ui.home.topstory

import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemTopStoryAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.TopStoryActivityBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel

class TopStoryActivity: BaseBindingActivity<TopStoryActivityBinding, TopStoryViewModel>() {
    lateinit var mainViewModel: MainViewModel
    private val listStory: MutableList<Story> = mutableListOf()
     private var itemTopStoryAdapter: ItemTopStoryAdapter?=null
    override fun getLayoutId(): Int {
        return R.layout.top_story_activity
    }
    override fun setupView(savedInstanceState: Bundle?) {
        initAdapter()
    }

    override fun setupData() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.initData(this)
        mainViewModel.listStoryLiveData.observe(this) { story ->
            listStory.addAll(story)
            itemTopStoryAdapter?.setListStory(story)
        }
    }
    private fun initAdapter() {
        itemTopStoryAdapter=ItemTopStoryAdapter().apply {
            binding.rcItemStory.adapter=this
        }
        itemTopStoryAdapter?.onItemClickListener=object :ItemTopStoryAdapter.ItemClickListener{
            override fun onItemClick(position: Int) {
               Log.e("tnghia","heh")
            }
        }
    }
    override fun getViewModel(): Class<TopStoryViewModel> {
        return TopStoryViewModel::class.java
    }
}