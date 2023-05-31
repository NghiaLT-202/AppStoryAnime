package com.example.appstory88.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.adapter.StoryBanerAdapter
import com.example.appstory88.databinding.HomeActivityBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.describestory.ViewDescribeStoryActivity
import com.example.appstory88.ui.morestory.ViewMoreStoryActivity

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    lateinit var binding: HomeActivityBinding
    private val listStory: MutableList<Story> = mutableListOf()
    lateinit var viewModel: MainViewModel
    private var storyGoodPassionAdapter: StoryAdapter? = null
    private var storyNewUpdateAdapter: StoryAdapter? = null
    private var storyGoodLoveLanguageAdapter: StoryAdapter? = null
    private var storyGoodFairyTaleAdapter: StoryAdapter? = null
    private var storyFullAdapter: StoryAdapter? = null

    private var storyBannerAdapter: StoryBanerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_activity)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        initAdapter()
        initListener()
        initData()
    }

    private fun initData() {
        viewModel.initData()
        viewModel.getAllListStory()
        viewModel.listStoryLiveData.observe(this) { story ->
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
        binding.imMenu.setOnClickListener {
            viewModel.getAllListStory()
        }
        intentActivity(binding.imViewMoreStoryFull, ViewMoreStoryActivity::class.java)
        intentActivity(binding.imViewMoreGoodPassion, ViewMoreStoryActivity::class.java)
        intentActivity(binding.imViewMoreGoodFairyTale, ViewMoreStoryActivity::class.java)
        intentActivity(binding.imViewMoreGoodLoveLanguage, ViewMoreStoryActivity::class.java)
        intentActivity(binding.imViewMoreNewStoryUpdated, ViewMoreStoryActivity::class.java)
    }

    private fun intentActivity(imageView: ImageView, activityClass: Class<*>) {
        imageView.setOnClickListener {
            val intent = Intent(imageView.context, activityClass)
            startActivity(intent)
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


    fun storyGoodPassionAdapter(rcItem: RecyclerView) {
        storyGoodPassionAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyGoodPassionAdapter!!)


    }

    fun storyNewUpdateAdapter(rcItem: RecyclerView) {
        storyNewUpdateAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyNewUpdateAdapter!!)

    }

    fun storyGoodLoveLanguageAdapter(rcItem: RecyclerView) {
        storyGoodLoveLanguageAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyGoodLoveLanguageAdapter!!)

    }

    fun storyGoodFairyTaleAdapter(rcItem: RecyclerView) {
        storyGoodFairyTaleAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyGoodFairyTaleAdapter!!)


    }

    fun storyFullAdapter(rcItem: RecyclerView) {
        storyFullAdapter = StoryAdapter().apply {
            rcItem.adapter = this
        }
        onClickItemStoryAdapter(storyFullAdapter!!)

    }

    fun onClickItemStoryAdapter(adapter: StoryAdapter) {
        adapter.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                intentActivity(ViewDescribeStoryActivity::class.java)

            }

        }
    }

    fun onclickBanerAdapter(adapter: StoryBanerAdapter) {
        adapter.iclick = object : StoryBanerAdapter.Iclick {
            override fun clickItem(position: Int) {
                intentActivity(ViewDescribeStoryActivity::class.java)
            }


        }
    }

    fun intentActivity(activityClass: Class<*>) {
        var intent = Intent(this@MainActivity, activityClass::class.java)

        startActivity(intent)
    }


}