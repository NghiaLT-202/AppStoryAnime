package com.example.appstory88.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.adapter.StoryBanerAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.HomeActivityBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.describestory.ViewDescribeStoryActivity
import com.example.appstory88.ui.home.category.CategoryStoryActicity
import com.example.appstory88.ui.home.ratestory.RateStoryActivity
import com.example.appstory88.ui.home.topstory.TopStoryActivity
import com.example.appstory88.ui.morestory.ViewMoreStoryActivity

class MainActivity : BaseBindingActivity<HomeActivityBinding, MainViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()
    private var storyGoodPassionAdapter: StoryAdapter? = null
    private var storyNewUpdateAdapter: StoryAdapter? = null
    private var storyGoodLoveLanguageAdapter: StoryAdapter? = null
    private var storyGoodFairyTaleAdapter: StoryAdapter? = null
    private var storyFullAdapter: StoryAdapter? = null


    private var storyBannerAdapter: StoryBanerAdapter? = null


    override fun getLayoutId(): Int {
        return R.layout.home_activity
    }

    override fun setupView(savedInstanceState: Bundle?) {
        initAdapter()
        initListener()
    }

    override fun setupData() {
        initData()
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    private fun initData() {
        viewModel.initData(this)
        viewModel.listStoryLiveData.observe(this) { story ->
            listStory.clear()
            listStory.addAll(story)
            storyGoodPassionAdapter?.setListStory(story)
            storyNewUpdateAdapter?.setListStory(story)
            storyGoodLoveLanguageAdapter?.setListStory(story)
            storyGoodFairyTaleAdapter?.setListStory(story)
            storyFullAdapter?.setListStory(story)
            storyBannerAdapter?.setListStoryBanner(story)
        }
    }

    private fun initListener() {
        binding.viewTopStory.setOnClickListener {
            intentActivity(TopStoryActivity::class.java, 0)

        }
        binding.viewCategory.setOnClickListener {
            intentActivity(CategoryStoryActicity::class.java, 0)
        }
        binding.viewRating.setOnClickListener {
            intentActivity(RateStoryActivity::class.java, 0)
        }
        binding.imViewMoreNewStoryUpdated.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java, 0)

        }
        binding.imViewMoreStoryFull.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java, 1)

        }
        binding.imViewMoreGoodLoveLanguage.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java, 2)
        }

        binding.imViewMoreGoodFairyTale.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java, 3)
        }
        binding.imViewMoreGoodPassion.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java, 4)

        }


    }


    private fun initAdapter() {
        storyBannerAdapter()
        storyNewUpdateAdapter(binding.rcItemStoryUpdateNew)
        storyFullAdapter(binding.rcItemStoryFull)
        storyGoodLoveLanguageAdapter(binding.rcItemGoodLoveLanguage)
        storyGoodFairyTaleAdapter(binding.rcItemGoodFairyTale)
        storyGoodPassionAdapter(binding.rcItemGoodPassion)


    }

    private fun storyBannerAdapter() {
        storyBannerAdapter = StoryBanerAdapter().apply {
            binding.rcItemStoryBanner.adapter = this
            listStory.shuffle()
            setListStoryBanner(listStory)
        }
        storyBannerAdapter?.iclick = object : StoryBanerAdapter.Iclick {
            override fun clickItem(position: Int) {
                intentActivityAndData(ViewDescribeStoryActivity::class.java, position)
            }
        }

    }


    private fun storyGoodPassionAdapter(rcItem: RecyclerView) {
        storyGoodPassionAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        storyGoodPassionAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                intentActivityAndData(ViewDescribeStoryActivity::class.java, position)

            }

        }


    }

    private fun storyNewUpdateAdapter(rcItem: RecyclerView) {
        storyNewUpdateAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        storyNewUpdateAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                intentActivityAndData(ViewDescribeStoryActivity::class.java, position)

            }

        }

    }

    private fun storyGoodLoveLanguageAdapter(rcItem: RecyclerView) {
        storyGoodLoveLanguageAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        storyGoodLoveLanguageAdapter?.onItemClickListener =
            object : StoryAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                    intentActivityAndData(ViewDescribeStoryActivity::class.java, position)

                }

            }
    }

    private fun storyGoodFairyTaleAdapter(rcItem: RecyclerView) {
        storyGoodFairyTaleAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        storyGoodFairyTaleAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                intentActivityAndData(ViewDescribeStoryActivity::class.java, position)

            }

        }

    }

    private fun storyFullAdapter(rcItem: RecyclerView) {
        storyFullAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        storyFullAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                intentActivityAndData(ViewDescribeStoryActivity::class.java, position)

            }

        }

    }


    private fun intentActivityAndData(activityClass: Class<*>, position: Int) {
        val intent = Intent(this, activityClass)
        intent.putExtra(Constant.IMAGE_STORY, listStory[position].imageStory)
        intent.putExtra(Constant.NAME_STORY, listStory[position].nameStory)
        intent.putExtra(Constant.NAME_AUTHUR_STORY, listStory[position].nameAuthur)
        intent.putExtra(Constant.NUMBER_STAR_STORY, listStory[position].numberStar)
        intent.putExtra(Constant.NUMBER_VIEW_STORY, listStory[position].numberView)
        intent.putExtra(Constant.STATUS_STORY, listStory[position].status)
        intent.putExtra(Constant.CATEGORY_STORY, listStory[position].nameCategory)
        intent.putExtra(Constant.DESCRIBE_STORY, listStory[position].describe)
        intent.putExtra(Constant.CHAPTER_STORY, listStory[position].chapter)
        intent.putExtra(Constant.CHAPTER_SUM_STORY, listStory[position].chapterSum)
        startActivity(intent)

    }

    private fun intentActivity(activityClass: Class<*>, position: Int) {
        val intent = Intent(this, activityClass)
        intent.putExtra(Constant.CATEGORY_STORY, listStory[position].nameCategory)
        startActivity(intent)

    }


}


