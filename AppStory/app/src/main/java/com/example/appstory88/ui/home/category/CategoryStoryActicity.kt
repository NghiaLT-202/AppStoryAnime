package com.example.appstory88.ui.home.category

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemCategoryStoryAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.ActivityCategoryStoryBinding
import com.example.appstory88.model.ItemCategory
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.home.topstory.detailstorytop.DetailStoryTopActivity

class CategoryStoryActicity :
    BaseBindingActivity<ActivityCategoryStoryBinding, CategoryStoryViewModel>() {
    lateinit var mainViewModel: MainViewModel
    private val listCategory: MutableList<ItemCategory> = mutableListOf()
    private var itemCategoryStoryAdapter: ItemCategoryStoryAdapter? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_category_story
    }

    override fun setupView(savedInstanceState: Bundle?) {
        initAdapter()
    }

    override fun setupData() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.initData(this)
        mainViewModel.listStoryLiveData.observe(this) {

            mainViewModel.initDataCategory(this,it)
        }
        mainViewModel.listCategoryLiveData.observe(this){
            listCategory.clear()
            listCategory.addAll(it)
            itemCategoryStoryAdapter?.listCategory=it
        }
    }

    private fun initAdapter() {
        itemCategoryStoryAdapter = ItemCategoryStoryAdapter().apply {
            binding.rcItemStory.adapter = this
            onItemClickListener = object : ItemCategoryStoryAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                    intentActivity(this@CategoryStoryActicity.listCategory[position])
                }
            }
        }
    }

    override fun getViewModel(): Class<CategoryStoryViewModel> {
        return CategoryStoryViewModel::class.java
    }

    private fun intentActivity(story: ItemCategory) {
        val intent = Intent(this, DetailStoryTopActivity::class.java)
        intent.putExtra(Constant.CATEGORY_STORY, story.name)
        startActivity(intent)

    }
}