package com.example.appstory88.ui.morestory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.LayoutViewListMoreStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel

class ViewMoreStoryActivity :
    BaseBindingActivity<LayoutViewListMoreStoryBinding, ViewMoreStoryModel>() {
    var storyAdapter: StoryAdapter? = null
    lateinit var mainViewModel:MainViewModel
    private val listStory: ArrayList<Story> = ArrayList<Story>()
    override fun getLayoutId(): Int {
        return R.layout.layout_view_list_more_story
    }

    override fun setupView(savedInstanceState: Bundle?) {
        mainViewModel=ViewModelProvider(this)[MainViewModel::class.java]
        initAdapter()
        initData()    }

    override fun setupData() {
    }

    override fun getViewModel(): Class<ViewMoreStoryModel> {
        return ViewMoreStoryModel::class.java
    }

    private fun initData() {

        mainViewModel.initData(this)
        mainViewModel.listStoryLiveData.observe(this) { story ->
            listStory.addAll(story)
            storyAdapter?.setListStory(listStory)
        }

    }

    private fun initAdapter() {
        storyAdapter = StoryAdapter().apply {
            binding.rcListStory.adapter = this
            setListStory(listStory)
        }


    }
}