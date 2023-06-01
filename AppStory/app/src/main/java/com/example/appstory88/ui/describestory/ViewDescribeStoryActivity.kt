package com.example.appstory88.ui.describestory

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.LayoutViewDescribeStoryBinding
import com.example.appstory88.ui.detailstory.DetailStoryActivity

class ViewDescribeStoryActivity :
    BaseBindingActivity<LayoutViewDescribeStoryBinding, ViewDescribeStoryViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.layout_view_describe_story
    }

    override fun setupView(savedInstanceState: Bundle?) {
        inlistener()
    }


    override fun setupData() {
        initData()

    }

    override fun getViewModel(): Class<ViewDescribeStoryViewModel> {
        return ViewDescribeStoryViewModel::class.java
    }
    private var chapter:String?=null

    private fun inlistener() {
        binding.tvReadStory.setOnClickListener {
            val intent = Intent(this, DetailStoryActivity::class.java)
            intent.putExtra("nameStory",binding.tvNameStory.text)
            intent.putExtra("describeStory",binding.tvValueDescribe.text)
            intent.putExtra("chapter",chapter)
            startActivity(intent)
        }
    }
    private fun initData() {
        binding.imStory.setImageResource(intent.getIntExtra("Image", 0))
        binding.tvNameStory.text = intent.getStringExtra("nameStory")
        binding.viewStar.numberStar = intent.getIntExtra("numberstar", 0)
        binding.tvValueView.text = intent.getLongExtra(("numberView"), 0).toString()
        binding.tvValueChapterNumber.text = intent.getIntExtra(("chapterSum"), 0).toString()
        binding.tvValueAuthur.text = intent.getStringExtra("nameAuthur")
        binding.tvValueCategory.text = intent.getStringExtra("category")
        binding.tvValueStatus.text = intent.getBooleanExtra("status", false).toString()
        binding.tvValueDescribe.text = intent.getStringExtra("describe")
        chapter=intent.getStringExtra("chapter")
    }
}