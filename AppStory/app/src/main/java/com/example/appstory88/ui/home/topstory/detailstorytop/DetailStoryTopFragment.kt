package com.example.appstory88.ui.home.topstory.detailstorytop

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.DetailStoryAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentDetailStoryTopBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.describestory.DetailStoryActivity
import com.google.gson.Gson

class DetailStoryTopFragment :
    BaseBindingActivity<FragmentDetailStoryTopBinding, DetailStoryTopViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()

    private lateinit var mainViewModel: MainViewModel
    private var detailStoryAdapter: DetailStoryAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail_story_top
    }

    override fun setupView(savedInstanceState: Bundle?) {
        initAdapter()
    }

    override fun setupData() {
        val category=intent.getStringExtra(Constant.CATEGORY_STORY)
        binding.tvNameCategory.text=category
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.initData(this)
        mainViewModel.listStoryLiveData.observe(this) { story ->
            listStory.clear()
            listStory.addAll(story)
            category?.let { mainViewModel.initlistDetailStoryLiveData(listStory, it) }

        }
        mainViewModel.listStoryDetailLiveData.observe(this){
            detailStoryAdapter?.listStory = it

        }
    }

    override fun getViewModel(): Class<DetailStoryTopViewModel> {
        return DetailStoryTopViewModel::class.java
    }

    private fun initAdapter() {
        detailStoryAdapter = DetailStoryAdapter().apply {
            binding.rcItemStory.adapter = this
            onItemClickListener = object : DetailStoryAdapter.ItemClickListener {
                override fun onItemClick(story: Story, position: Int) {
                    intentActivityAndData(story,position)
                }
            }

        }
    }

    private fun intentActivityAndData(story: Story, position:Int) {
        val intent = Intent(this, DetailStoryActivity::class.java)
        intent.putExtra(
            Constant.KEY_DETAIL_STORY,
            Gson().toJson(detailStoryAdapter?.listStory?.get(position))
        )
        startActivity(intent)

    }

}