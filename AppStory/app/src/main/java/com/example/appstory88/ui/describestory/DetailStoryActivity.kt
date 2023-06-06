package com.example.appstory88.ui.describestory

import android.content.Intent
import android.os.Bundle
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.ActivityDescribeStoryBinding
import com.example.appstory88.ui.detailstory.ReadStoryActivity
import java.text.DecimalFormat
import java.text.NumberFormat

class DetailStoryActivity :
    BaseBindingActivity<ActivityDescribeStoryBinding, DetailStoryViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_describe_story
    }

    override fun setupView(savedInstanceState: Bundle?) {
        inlistener()
    }

    override fun setupData() {
        initData()
    }

    override fun getViewModel(): Class<DetailStoryViewModel> {
        return DetailStoryViewModel::class.java
    }

    private var chapter: String? = null
    private fun inlistener() {
        binding.imBack.setOnClickListener {
            finish()
        }
        binding.tvReadStory.setOnClickListener {
            val intent = Intent(this, ReadStoryActivity::class.java)
            intent.putExtra(Constant.NAME_STORY, binding.tvNameStory.text)
            intent.putExtra(Constant.DESCRIBE_STORY, binding.tvValueDescribe.text)
            intent.putExtra(Constant.CHAPTER_STORY, chapter)
            startActivity(intent)
        }
    }

    private fun initData() {
        binding.imStory.setImageResource(intent.getIntExtra(Constant.IMAGE_STORY, 0))
        binding.tvNameStory.text = intent.getStringExtra(Constant.NAME_STORY)
        binding.viewStar.numberStar = intent.getIntExtra(Constant.NUMBER_STAR_STORY, 0)
        val views = intent.getLongExtra((Constant.NUMBER_VIEW_STORY), 0)

        val decimalFormat = DecimalFormat("#,###")
        val formattedViews = decimalFormat.format(views)
        binding.tvValueView.text = formattedViews
        binding.tvValueChapterNumber.text =
            intent.getIntExtra((Constant.CHAPTER_SUM_STORY), 0).toString()
        binding.tvValueAuthur.text = intent.getStringExtra(Constant.NAME_AUTHUR_STORY)
        binding.tvValueCategory.text = intent.getStringExtra(Constant.CATEGORY_STORY)
        binding.tvValueStatus.text = intent.getBooleanExtra(Constant.STATUS_STORY, false).toString()
        binding.tvValueDescribe.text = intent.getStringExtra(Constant.DESCRIBE_STORY)
        chapter = intent.getStringExtra(Constant.CHAPTER_STORY)
    }
}