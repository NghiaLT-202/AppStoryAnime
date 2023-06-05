package com.example.appstory88.ui.home.category

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemCategoryStoryAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.CategoryActivityBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.morestory.ViewMoreStoryActivity

class CategoryStoryActicity : BaseBindingActivity<CategoryActivityBinding, CategoryStoryViewModel>() {
    lateinit var mainViewModel: MainViewModel
    private val listStory: MutableList<Story> = mutableListOf()
    private var itemCategoryStoryAdapter: ItemCategoryStoryAdapter?=null
    override fun getLayoutId(): Int {
        return R.layout.category_activity
    }
    override fun setupView(savedInstanceState: Bundle?) {
        initAdapter()
    }

    override fun setupData() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.initData(this)
        mainViewModel.listStoryLiveData.observe(this) { story ->
            listStory.clear()
            listStory.addAll(story)
            itemCategoryStoryAdapter?.listStory=story
        }
    }
    private fun initAdapter() {
        itemCategoryStoryAdapter= ItemCategoryStoryAdapter().apply {
            binding.rcItemStory.adapter=this
        }
        itemCategoryStoryAdapter?.onItemClickListener=object : ItemCategoryStoryAdapter.ItemClickListener{
            override fun onItemClick(position: Int) {
                intentActivity(listStory[position])

            }
        }
    }
    override fun getViewModel(): Class<CategoryStoryViewModel> {
        return CategoryStoryViewModel::class.java
    }
    private fun intentActivity( story: Story) {
        val intent = Intent(this, ViewMoreStoryActivity::class.java)
        intent.putExtra(Constant.CATEGORY_STORY, story.nameCategory)
        startActivity(intent)

    }
}