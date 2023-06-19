package com.example.appstory88.ui.describestory

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemCategoryDetailAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentDetailStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.ui.MainViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailStoryFragment :
    BaseBindingFragment<FragmentDetailStoryBinding, DetailStoryViewModel>() {
    private var story: Story? = null


    private var itemCategoryDetailAdapter: ItemCategoryDetailAdapter? = null
    var listCategoryStory: MutableList<Story> = mutableListOf()

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        makeStatusBarLight(requireActivity(), Color.parseColor("#52322C2A"))
        inlistener()
        initAdapter()
        setupData()
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

    fun setupData() {
        val storyJson = arguments?.getString(Constant.KEY_DETAIL_STORY)
        story = Gson().fromJson<Story>(storyJson, object : TypeToken<Story>() {}.type)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel?.initData(requireContext())
        mainViewModel?.listStoryLiveData?.observe(this) { story ->
            listCategoryStory.clear()
            listCategoryStory.addAll(story)
            itemCategoryDetailAdapter?.listCategoryStory = listCategoryStory
        }
        initData()
    }

    override fun getViewModel(): Class<DetailStoryViewModel> {
        return DetailStoryViewModel::class.java
    }

    private fun inlistener() {
        binding.imBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        binding.tvReadStory.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(
                Constant.KEY_DETAIL_STORY,
                Gson().toJson(story)
            )
            (requireActivity() as MainActivity).navController?.navigate(
                R.id.fragment_read_story,
                bundle
            )
        }
    }

    private fun initData() {
        story?.let {
            Glide.with(this).load(it.imageStory).into(binding.imStory)

            binding.tvNameStory.text = it.nameStory
            binding.viewStar.numberStar = it.numberStar
            binding.tvValueView.text = it.numberView.toString()
            binding.tvValueChapterNumber.text = it.chapterSum.toString()
            binding.tvValueAuthur.text = it.nameAuthur
            binding.tvValueStatus.text = it.status.toString()
            binding.tvValueDescribe.text = it.describe
        }

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