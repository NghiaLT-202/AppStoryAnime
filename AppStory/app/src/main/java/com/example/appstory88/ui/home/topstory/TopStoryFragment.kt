package com.example.appstory88.ui.home.topstory

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemTopStoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentTopStoryBinding
import com.example.appstory88.model.ItemTopStory
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.home.topstory.detailstorytop.DetailStoryTopActivity

class TopStoryFragment : BaseBindingFragment<FragmentTopStoryBinding, TopStoryViewModel>() {
    private lateinit var mainViewModel: MainViewModel
    private val listStory: MutableList<ItemTopStory> = mutableListOf()
    private var itemTopStoryAdapter: ItemTopStoryAdapter? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_top_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initListener()
        initAdapter()
        setupData()
    }

    private fun initListener() {


    }

     fun setupData() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.initDataTopStory(this)
        mainViewModel.listTopStoryLiveData.observe(this) {
            listStory.clear()
            listStory.addAll(it)
            itemTopStoryAdapter?.listStory = it
        }
    }

    private fun initAdapter() {
        itemTopStoryAdapter = ItemTopStoryAdapter().apply {
            binding.rcItemStory.adapter = this
            onItemClickListener = object : ItemTopStoryAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                    intentActivity(listStory[position])
                }
            }
        }
    }

    override fun getViewModel(): Class<TopStoryViewModel> {
        return TopStoryViewModel::class.java
    }

    private fun intentActivity(story: ItemTopStory) {
        val intent = Intent(this, DetailStoryTopActivity::class.java)
        intent.putExtra(Constant.CATEGORY_STORY, story.name)
        startActivity(intent)

    }
}