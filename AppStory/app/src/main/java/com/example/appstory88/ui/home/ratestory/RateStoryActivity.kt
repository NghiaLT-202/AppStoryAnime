package com.example.appstory88.ui.home.ratestory

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.RateStoryAdapter
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.RateActivityBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.describestory.ViewDescribeStoryActivity

class RateStoryActivity : BaseBindingActivity<RateActivityBinding, RateStoryViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()

    lateinit var mainViewModel: MainViewModel
    private lateinit var rateStoryAdapter: RateStoryAdapter
    override fun getLayoutId(): Int {
        return R.layout.rate_activity
    }

    override fun setupView(savedInstanceState: Bundle?) {
        initAdapter()
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.initData()
        mainViewModel.listStoryLiveData.observe(this) { story ->
            rateStoryAdapter.setListStory(story)
            listStory.addAll(story)
        }

    }

    override fun setupData() {



    }

    private fun initAdapter() {
        rateStoryAdapter = RateStoryAdapter().apply {
            binding.rcItemStory.adapter=this
        }
        rateStoryAdapter.onItemClickListener = object : RateStoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                intentActivityAndData(ViewDescribeStoryActivity::class.java,position)


            }

        }
    }


    override fun getViewModel(): Class<RateStoryViewModel> {
        return RateStoryViewModel::class.java
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

    }
}