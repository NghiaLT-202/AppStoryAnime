package com.example.appstory88.ui.home.topstory.detailstorytop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.DetailStoryAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.ActivityDetailStoryTopBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.describestory.DetailStoryActivity

class DetailStoryTopActivity :
    BaseBindingActivity<ActivityDetailStoryTopBinding, DetailStoryTopViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()

    private var mainViewModel: MainViewModel? = null
    private var detailStoryAdapter: DetailStoryAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_detail_story_top
    }

    override fun setupView(savedInstanceState: Bundle?) {
        initAdapter()
    }

    override fun setupData() {
        val category=intent.getStringExtra(Constant.CATEGORY_STORY)
        binding.tvNameCategory.text=category
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel?.initData(this)
        mainViewModel?.listStoryLiveData?.observe(this) { story ->
            listStory.clear()
            listStory.addAll(story)
//            category?.let { mainViewModel?.initlistDetailStoryLiveData(listStory, it) }
            listStory.filter { it.nameCategory==category }

            detailStoryAdapter?.listStory = listStory

        }
    }

    override fun getViewModel(): Class<DetailStoryTopViewModel> {
        return DetailStoryTopViewModel::class.java
    }

    private fun initAdapter() {
        detailStoryAdapter = DetailStoryAdapter().apply {
            binding.rcItemStory.adapter = this
            onItemClickListener = object : DetailStoryAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                    intentActivityAndData(listStory[position])

                }
            }

        }
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