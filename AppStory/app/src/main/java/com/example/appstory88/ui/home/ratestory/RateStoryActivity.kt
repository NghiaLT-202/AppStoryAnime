package com.example.appstory88.ui.home.ratestory

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.RateStoryAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.ActivityRateStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.describestory.DetailStoryActivity

class RateStoryActivity : BaseBindingActivity<ActivityRateStoryBinding, RateStoryViewModel>() {
//    private val listStory: MutableList<Story> = mutableListOf()
    private var mainViewModel: MainViewModel? = null
    private var rateStoryAdapter: RateStoryAdapter? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_rate_story
    }

    override fun setupView(savedInstanceState: Bundle?) {
        initAdapter()


    }

    override fun setupData() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel?.initData(this)
        mainViewModel?.listStoryLiveData?.observe(this) { story ->
            mainViewModel?.initListRateStoryLiveData(story)
            rateStoryAdapter?.listStory = story

        }

    }

    private fun initAdapter() {
        rateStoryAdapter = RateStoryAdapter().apply {
            binding.rcItemStory.adapter = this
            onItemClickListener = object : RateStoryAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                    intentActivityAndData(listStory[position])

                }
            }

        }
    }


    override fun getViewModel(): Class<RateStoryViewModel> {
        return RateStoryViewModel::class.java
    }

    private fun intentActivityAndData(story: Story) {
        val intent = Intent(this, DetailStoryActivity::class.java)
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