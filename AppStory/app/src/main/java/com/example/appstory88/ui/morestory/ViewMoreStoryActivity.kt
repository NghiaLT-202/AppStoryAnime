package com.example.appstory88.ui.morestory

import android.content.Intent

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.base.BaseBindingActivity

import com.example.appstory88.commom.Constant

import com.example.appstory88.databinding.LayoutViewListMoreStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.describestory.ViewDescribeStoryActivity

class ViewMoreStoryActivity :
    BaseBindingActivity<LayoutViewListMoreStoryBinding, ViewMoreStoryModel>() {
    var storyAdapter: StoryAdapter? = null
    lateinit var mainViewModel: MainViewModel
    private val listStory: MutableList<Story> = mutableListOf()
    private var listStoryCategory: MutableList<Story> = mutableListOf()
    override fun getLayoutId(): Int {
        return R.layout.layout_view_list_more_story
    }

    override fun setupView(savedInstanceState: Bundle?) {
        binding.imBack.setOnClickListener {
            finish()
        }
        initAdapter()
    }

    override fun setupData() {
        val category=intent.getStringExtra(Constant.CATEGORY_STORY)
        binding.nameCategory.text=category
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.initData(this)
        mainViewModel.listStoryLiveData.observe(this) { story ->
            listStory.addAll(story)
            listStoryCategory = listStory.filter { it.nameCategory.equals(category,ignoreCase = true) } as MutableList<Story>
            storyAdapter?.setListStory(listStoryCategory)
        }
    }



    override fun getViewModel(): Class<ViewMoreStoryModel> {
        return ViewMoreStoryModel::class.java
    }


    private fun initAdapter() {
        storyAdapter = StoryAdapter().apply {
            binding.rcListStory.adapter = this
        }
        storyAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                intentActivityAndData(ViewDescribeStoryActivity::class.java, position)
            }

        }

    }

    private fun intentActivityAndData(activityClass: Class<*>, position: Int) {
        val intent = Intent(this, activityClass)
        intent.putExtra(Constant.IMAGE_STORY, listStoryCategory[position].imageStory)
        intent.putExtra(Constant.NAME_STORY, listStoryCategory[position].nameStory)
        intent.putExtra(Constant.NAME_AUTHUR_STORY, listStoryCategory[position].nameAuthur)
        intent.putExtra(Constant.NUMBER_STAR_STORY, listStoryCategory[position].numberStar)
        intent.putExtra(Constant.NUMBER_VIEW_STORY, listStoryCategory[position].numberView)
        intent.putExtra(Constant.STATUS_STORY, listStoryCategory[position].status)
        intent.putExtra(Constant.CATEGORY_STORY, listStoryCategory[position].nameCategory)
        intent.putExtra(Constant.DESCRIBE_STORY, listStoryCategory[position].describe)
        intent.putExtra(Constant.CHAPTER_STORY, listStoryCategory[position].chapter)
        intent.putExtra(Constant.CHAPTER_SUM_STORY, listStoryCategory[position].chapterSum)
        startActivity(intent)

    }
}