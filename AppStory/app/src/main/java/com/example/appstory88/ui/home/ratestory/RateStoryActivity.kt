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
import com.google.gson.Gson

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
                    intentActivityAndData(listStory[position],position)

                }
            }

        }
    }


    override fun getViewModel(): Class<RateStoryViewModel> {
        return RateStoryViewModel::class.java
    }

    private fun intentActivityAndData(story: Story,position: Int) {
        val intent = Intent(this, DetailStoryActivity::class.java)
        intent.putExtra(
            Constant.KEY_DETAIL_STORY,
            Gson().toJson(rateStoryAdapter?.listStory?.get(position))
        )
        startActivity(intent)

    }
}