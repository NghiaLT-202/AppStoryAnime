package com.example.appstory88.ui.describestory

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemCategoryDetailAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.dao.StoryDao
import com.example.appstory88.database.AppDatabase
import com.example.appstory88.databinding.FragmentDetailStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.utils.MakeStatusBarLight

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailStoryFragment :
    BaseBindingFragment<FragmentDetailStoryBinding, DetailStoryViewModel>() {
    private var story: Story? = null
    var storyDao : StoryDao?=null

    private var itemCategoryDetailAdapter: ItemCategoryDetailAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        MakeStatusBarLight.makeStatusBarLight(requireActivity(), R.color.statusbarlight)
        initListener()
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

    private fun setupData() {
        val storyJson = arguments?.getString(Constant.KEY_DETAIL_STORY)
        story = Gson().fromJson<Story>(storyJson, object : TypeToken<Story>() {}.type)
        mainViewModel?.initData(requireContext())
        mainViewModel?.listStoryLiveData?.observe(this) {
            story?.nameStory?.let { it1 -> mainViewModel.initlistCategoryData(it, it1) }
        }
        mainViewModel.listCategoryData.observe(this){
            itemCategoryDetailAdapter?.listCategoryStory = it

        }
        initData()
    }

    override fun getViewModel(): Class<DetailStoryViewModel> {
        return DetailStoryViewModel::class.java
    }

    private fun initListener() {
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
        binding.tvBookmark.setOnClickListener {
            storyDao= AppDatabase.getInstanceDataBase(requireContext()).storyDao()
            story?.let { it1 -> storyDao?.insertStory(it1) }
        }
    }

    private fun initData() {
        story?.let {
            with(binding) {
                Glide.with(requireContext()).load(it.imageStory).into(imStory)
                tvNameStory.text = it.nameStory
                viewStar.numberStar = it.numberStar
                tvValueView.text = it.numberView.toString()
                tvValueChapterNumber.text = it.chapterSum.toString()
                tvValueAuthur.text = it.nameAuthur
                tvValueStatus.text = it.status.toString()
                tvValueDescribe.text = it.describe
            }

        }

    }


}