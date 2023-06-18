package com.example.appstory88.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.adapter.StoryBannerAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentHomeStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.describestory.DetailStoryActivity
import com.example.appstory88.ui.home.bookmark.BookmarkActivity
import com.example.appstory88.ui.home.category.CategoryStoryActicity
import com.example.appstory88.ui.home.ratestory.RateStoryActivity
import com.example.appstory88.ui.home.topstory.TopStoryActivity
import com.google.gson.Gson

class HomeFragment: BaseBindingFragment<FragmentHomeStoryBinding, MainViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()
    private var storyNewUpdateAdapter: StoryAdapter? = null
    private val listStoryNewUpdate: MutableList<Story> = mutableListOf()

    private var storyFullAdapter: StoryAdapter? = null
    private val listStoryFull: MutableList<Story> = mutableListOf()

    private var storyGoodLoveLanguageAdapter: StoryAdapter? = null
    private val listStoryGoodLoveLanguage: MutableList<Story> = mutableListOf()

    private var storyGoodFairyTaleAdapter: StoryAdapter? = null
    private val listStoryGoodFairyTale: MutableList<Story> = mutableListOf()

    private var storyGoodPassionAdapter: StoryAdapter? = null
    private val listStoryGoodPassion: MutableList<Story> = mutableListOf()

    private var storyBannerAdapter: StoryBannerAdapter? = null
    private val listStoryBanner: MutableList<Story> = mutableListOf()


    override fun getLayoutId(): Int {
        return R.layout.fragment_home_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        setupView()
        setupData()
    }

     fun setupView() {

        binding.rcFullStory.textCategory = getString(R.string.truy_n_full)
        binding.rcLoveLanguageStory.textCategory = getString(R.string.good_love_language)
        binding.rcFirstHalfStory.textCategory = getString(R.string.good_fairy_tale)
        binding.rcPassionStory.textCategory = getString(R.string.good_passion)
        binding.rcNewUpdateStory.textCategory = getString(R.string.new_story_updated)
        initAdapter()
        initListener()
    }

     fun setupData() {
        initData()
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    private fun initData() {
        viewModel.initData(this)
        viewModel.listStoryLiveData.observe(this) { story ->
            listStory.clear()
            listStoryBanner.clear()
            listStory.addAll(story)
            listStoryBanner.addAll(story)
//            viewModel.initlistStoryNewUpdateLiveData(listStory)
//            viewModel.initlistStoryFullAdapterLiveData(listStory)
//            viewModel.initlistStoryGoodLoveLanguageLiveData(listStory)
//            viewModel.initlistStoryGoodFairyTaleLiveData(listStory)
//            viewModel.initlistStoryGoodPassionLiveData(listStory)
            binding.rcLoveLanguageStory.listPreviewStory = story
            binding.rcFullStory.listPreviewStory = story
            binding.rcFirstHalfStory.listPreviewStory = story
            binding.rcPassionStory.listPreviewStory = story
            binding.rcNewUpdateStory.listPreviewStory = story
            storyBannerAdapter?.listStory=listStory
        }
//        viewModel.listStoryNewUpdateLiveData.observe(this) { newUpdate ->
//            listStoryNewUpdate.clear()
//            listStoryNewUpdate.addAll(newUpdate)
//            storyNewUpdateAdapter?.listStory=newUpdate
//        }
//        viewModel.listStoryFullAdapterLiveData.observe(this) { storyFull ->
//            listStoryFull.clear()
//            listStoryFull.addAll(storyFull)
//
//            storyFullAdapter?.listStory=storyFull
//
//        }
//        viewModel.listStoryGoodLoveLanguageLiveData.observe(this) { goodLove ->
//            listStoryGoodLoveLanguage.clear()
//            listStoryGoodLoveLanguage.addAll(goodLove)
//
//            storyGoodLoveLanguageAdapter?.listStory=goodLove
//        }
//        viewModel.listStoryGoodFairyTaleLiveData.observe(this) { goodFairyTale ->
//            listStoryGoodFairyTale.clear()
//            listStoryGoodFairyTale.addAll(goodFairyTale)
//            storyGoodFairyTaleAdapter?.listStory=goodFairyTale
//
//        }
//        viewModel.listStoryGoodPassionLiveData.observe(this) { goodPassion ->
//            listStoryGoodPassion.clear()
//            listStoryGoodPassion.addAll(goodPassion)
//            storyGoodPassionAdapter?.listStory=goodPassion
//
//        }
    }


    private fun initListener() {
        binding.viewTopStory.setOnClickListener {
            intentActivity(TopStoryActivity::class.java, 0)

        }
        binding.viewCategoryStory.setOnClickListener {
            intentActivity(CategoryStoryActicity::class.java, 0)
        }
        binding.viewRateStory.setOnClickListener {
            intentActivity(RateStoryActivity::class.java, 0)
        }
        binding.viewBookMarkStory.setOnClickListener {
            intentActivity(BookmarkActivity::class.java, 0)

        }




    }


    private fun initAdapter() {
        storyBannerAdapter()
        storyGoodFairyTaleAdapter()
        storyNewUpdateAdapter()
        storyFullAdapter()
        storyGoodLoveLanguageAdapter()
        storyGoodFairyTaleAdapter()
        storyGoodPassionAdapter()


    }

    private fun storyBannerAdapter() {
        storyBannerAdapter = StoryBannerAdapter().apply {
            binding.rcItemStoryBanner.adapter = this
            iclick = object : StoryBannerAdapter.IClick {
                override fun clickItem(story: Story, position: Int) {
                    intentActivityAndData(story,position)
                }
            }
        }

    }

    private fun storyNewUpdateAdapter() {
        binding.rcNewUpdateStory.listStoryPreviewAdapter!!.onItemClickListener= object : StoryAdapter.ItemClickListener {
            override fun onItemClick(story: Story, position: Int) {
                intentActivityAndData(story,position)
            }
        }


    }

    private fun storyFullAdapter() {
        binding.rcFullStory.listStoryPreviewAdapter!!.onItemClickListener= object : StoryAdapter.ItemClickListener {
            override fun onItemClick(story: Story, position: Int) {
                intentActivityAndData(story,position)
            }
        }

    }

    private fun storyGoodLoveLanguageAdapter() {
        binding.rcLoveLanguageStory.listStoryPreviewAdapter!!.onItemClickListener= object : StoryAdapter.ItemClickListener {
            override fun onItemClick(story: Story, position: Int) {
                intentActivityAndData(story,position)
            }
        }
    }

    private fun storyGoodFairyTaleAdapter() {
        binding.rcFirstHalfStory.listStoryPreviewAdapter!!.onItemClickListener= object : StoryAdapter.ItemClickListener {
            override fun onItemClick(story: Story, position: Int) {
                intentActivityAndData(story,position)
            }
        }

    }


    private fun storyGoodPassionAdapter() {

        binding.rcPassionStory.listStoryPreviewAdapter!!.onItemClickListener= object : StoryAdapter.ItemClickListener {
            override fun onItemClick(story: Story, position: Int) {
                intentActivityAndData(story,position)
            }
        }

    }


    private fun intentActivityAndData(story: Story, position: Int) {

        val intent = Intent(this, DetailStoryActivity::class.java)
        intent.putExtra(
            Constant.KEY_DETAIL_STORY,
            Gson().toJson(storyBannerAdapter?.listStory?.get(position))
        )
        startActivity(intent)


    }

    private fun intentActivity(activityClass: Class<*>, position: Int) {
        val intent = Intent(this, activityClass)
        intent.putExtra(Constant.CATEGORY_STORY, listStory[position].nameCategory[0])
        startActivity(intent)

    }


}
