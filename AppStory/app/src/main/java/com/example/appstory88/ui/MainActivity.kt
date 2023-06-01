package com.example.appstory88.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.recyclerview.widget.RecyclerView
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.adapter.StoryBanerAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.HomeActivityBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.describestory.ViewDescribeStoryActivity
import com.example.appstory88.ui.home.ratestory.RateStoryActivity
import com.example.appstory88.ui.morestory.ViewMoreStoryActivity
import java.text.FieldPosition

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
        viewModel.initData()
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
        binding.viewRating.setOnClickListener {
            intentActivity(RateStoryActivity::class.java)
        }

        binding.imViewMoreStoryFull.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java)

        }
        binding.imViewMoreGoodPassion.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java)

        }
        binding.imViewMoreGoodFairyTale.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java)

        }
        binding.imViewMoreGoodLoveLanguage.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java)

        }
        binding.imViewMoreNewStoryUpdated.setOnClickListener {
            intentActivity(ViewMoreStoryActivity::class.java)

        }

    }



    private fun initAdapter() {

        eventAdapterBanner()
        storyNewUpdateAdapter(binding.rcItemStoryUpdateNew)
        storyFullAdapter(binding.rcItemStoryFull)
        storyGoodLoveLanguageAdapter(binding.rcItemGoodLoveLanguage)
        storyGoodFairyTaleAdapter(binding.rcItemGoodFairyTale)
        storyGoodPassionAdapter(binding.rcItemGoodPassion)


    }

    private fun eventAdapterBanner() {
        storyBannerAdapter = StoryBanerAdapter().apply {
            binding.rcItemStoryBanner.adapter = this
            listStory.shuffle()
            setListStoryBanner(listStory)
        }
        onclickBanerAdapter(storyBannerAdapter!!)


    }


    private fun storyGoodPassionAdapter(rcItem: RecyclerView) {
        storyGoodPassionAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyGoodPassionAdapter!!)


    }

    private fun storyNewUpdateAdapter(rcItem: RecyclerView) {
        storyNewUpdateAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyNewUpdateAdapter!!)

    }

    private fun storyGoodLoveLanguageAdapter(rcItem: RecyclerView) {
        storyGoodLoveLanguageAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyGoodLoveLanguageAdapter!!)
    }

    private fun storyGoodFairyTaleAdapter(rcItem: RecyclerView) {
        storyGoodFairyTaleAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyGoodFairyTaleAdapter!!)


    }

    private fun storyFullAdapter(rcItem: RecyclerView) {
        storyFullAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyFullAdapter!!)

    }

    private fun onClickItemStoryAdapter(adapter: StoryAdapter) {
        adapter.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                intentActivityAndData(ViewDescribeStoryActivity::class.java,position)

            }

        }
    }

    private fun onclickBanerAdapter(adapter: StoryBanerAdapter) {
        adapter.iclick = object : StoryBanerAdapter.Iclick {
            override fun clickItem(position: Int) {
                intentActivityAndData(ViewDescribeStoryActivity::class.java,position)
            }


        }
    }
    private fun intentActivityAndData(activityClass: Class<*>,position: Int) {
        val intent = Intent(this, activityClass)
        intent.putExtra("Image",listStory[position].imageStory)
        intent.putExtra("nameStory",listStory[position].nameStory)
        intent.putExtra("nameAuthur",listStory[position].nameAuthur)
        intent.putExtra("numberstar",listStory[position].numberStar)
        intent.putExtra("numberView",listStory[position].numberView)
        intent.putExtra("status",listStory[position].status)
        intent.putExtra("category",listStory[position].nameCategory)
        intent.putExtra("describe",listStory[position].describe)
        intent.putExtra("chapter",listStory[position].chapter)

        intent.putExtra("chapterSum",listStory[position].chapterSum)
        startActivity(intent)

    } private fun intentActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)

    }


}