package com.example.appstory88.ui.describestory

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemCategoryDetailAdapter
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.ActivityDescribeStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainViewModel
import com.example.appstory88.ui.detailstory.ReadStoryActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.DecimalFormat

class DetailStoryActivity :
    BaseBindingActivity<ActivityDescribeStoryBinding, DetailStoryViewModel>() {
    private var mainViewModel: MainViewModel? = null
    private var story: Story? = null


    private var itemCategoryDetailAdapter: ItemCategoryDetailAdapter? = null
    var listCategoryStory: MutableList<Story> = mutableListOf()

    override fun getLayoutId(): Int {
        return R.layout.activity_describe_story
    }

    override fun setupView(savedInstanceState: Bundle?) {

        makeStatusBarLight(this, Color.parseColor("#52322C2A"))

        inlistener()
        initAdapter()
    }

    private fun initAdapter() {

        itemCategoryDetailAdapter = ItemCategoryDetailAdapter().apply {
            binding.rcCategory.adapter = this
            onItemClickListener = object : ItemCategoryDetailAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                }

            }
        }

    }

    override fun setupData() {
        story = Gson().fromJson(
            intent.getStringExtra(Constant.KEY_DETAIL_STORY), object : TypeToken<Story>() {}.type
        )
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel?.initData(this)
        mainViewModel?.listStoryLiveData?.observe(this) { story ->
            listCategoryStory.clear()
            Log.e("tnghia",""+listCategoryStory.size)
            listCategoryStory.addAll(story)
            itemCategoryDetailAdapter?.listCategoryStory = listCategoryStory
        }
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
        story?.let {
//            Glide.with(this).load(it.imageStory).into(binding.imStory)
            binding.imStory.setImageResource(it.imageStory)
            binding.tvNameStory.text=it.nameStory
            binding.viewStar.numberStar = it.numberStar
            binding.tvValueView.text = it.numberView.toString()
            binding.tvValueChapterNumber.text=it.chapterSum.toString()

            binding.tvValueAuthur.text = it.nameAuthur
            binding.tvValueStatus.text=it.status.toString()
            binding.tvValueDescribe.text=it.describe
        }
//        binding.imStory.setImageResource(intent.getIntExtra(Constant.IMAGE_STORY, 0))
//        binding.tvNameStory.text = intent.getStringExtra(Constant.NAME_STORY)
//        binding.viewStar.numberStar = intent.getIntExtra(Constant.NUMBER_STAR_STORY, 0)
//        val views = intent.getLongExtra((Constant.NUMBER_VIEW_STORY), 0)
//        val decimalFormat = DecimalFormat("#,###")
//        val formattedViews = decimalFormat.format(views)
//        binding.tvValueView.text = formattedViews
//        binding.tvValueChapterNumber.text =
//            intent.getIntExtra((Constant.CHAPTER_SUM_STORY), 0).toString()
//        binding.tvValueAuthur.text = intent.getStringExtra(Constant.NAME_AUTHUR_STORY)
////        binding.tvValueCategory.text = intent.getStringExtra(Constant.CATEGORY_STORY)
//        binding.tvValueStatus.text = intent.getBooleanExtra(Constant.STATUS_STORY, false).toString()
//        binding.tvValueDescribe.text = intent.getStringExtra(Constant.DESCRIBE_STORY)
//        chapter = intent.getStringExtra(Constant.CHAPTER_STORY)
    }

    private fun makeStatusBarLight(activity: Activity, color: Int) {
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = color
        activity.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
    }
}