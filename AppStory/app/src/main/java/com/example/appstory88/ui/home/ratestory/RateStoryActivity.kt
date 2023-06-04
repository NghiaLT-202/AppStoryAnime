package com.example.appstory88.ui.home.ratestory

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.RateStoryAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.RateActivityBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.describestory.ViewDescribeStoryActivity

class RateStoryActivity : BaseBindingActivity<RateActivityBinding, RateStoryViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()

    private var mainViewModel: MainViewModel?=null
    private lateinit var rateStoryAdapter: RateStoryAdapter
    override fun getLayoutId(): Int {
        return R.layout.rate_activity
    }
    override fun setupView(savedInstanceState: Bundle?) {
        initAdapter()
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel?.initData(this)
        mainViewModel?.listStoryLiveData?.observe(this) { story ->
            rateStoryAdapter.setListStory(story)
            listStory.addAll(story)
        }

    }

    override fun setupData() {


    }

    private fun initAdapter() {
        rateStoryAdapter = RateStoryAdapter().apply {
            binding.rcItemStory.adapter = this
        }
        rateStoryAdapter.onItemClickListener = object : RateStoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                intentActivityAndData(listStory[position])

            }

        }
    }


    override fun getViewModel(): Class<RateStoryViewModel> {
        return RateStoryViewModel::class.java
    }

    private fun intentActivityAndData(story: Story) {
        val intent = Intent(this, ViewDescribeStoryActivity::class.java)
        intent.putExtra(Constant.IMAGE_STORY, story.imageStory)
        intent.putExtra(Constant.NAME_STORY, story.nameStory)
        intent.putExtra(Constant.NAME_AUTHUR_STORY, story.nameAuthur)
        intent.putExtra(Constant.NUMBER_STAR_STORY, story.numberStar)
        intent.putExtra(Constant.NUMBER_VIEW_STORY, story.numberView)
        intent.putExtra(Constant.STATUS_STORY, story.status)
        intent.putExtra(Constant.CATEGORY_STORY, story.nameCategory)
        intent.putExtra(Constant.DESCRIBE_STORY, story.describe)
        intent.putExtra(Constant.CHAPTER_STORY, story.chapter)
        intent.putExtra(Constant.CHAPTER_SUM_STORY, story.chapterSum)
        startActivity(intent)

    }
}