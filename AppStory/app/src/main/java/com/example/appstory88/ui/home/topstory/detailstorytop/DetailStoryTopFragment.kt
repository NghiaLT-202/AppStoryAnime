package com.example.appstory88.ui.home.topstory.detailstorytop

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.adapter.DetailStoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.data.model.Story
import com.example.appstory88.databinding.FragmentDetailStoryTopBinding
import com.example.appstory88.utils.StatusBarUtils
import com.google.gson.Gson

class DetailStoryTopFragment :
    BaseBindingFragment<FragmentDetailStoryTopBinding, DetailCategoryViewModel>() {
    private val listStoryOfCategory: MutableList<Story> = mutableListOf()
    private var detailStoryAdapter: DetailStoryAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail_story_top
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        StatusBarUtils.makeStatusBarLight(
            requireActivity(),
            ContextCompat.getColor(requireActivity(), R.color.white)
        )

        setupViews()
        setupData()
    }

    private fun setupViews() {
        initAdapter()
    }

    private fun setupData() {
        (arguments?.getString(Constant.CATEGORY_STORY) ?: "").apply {
            binding.tvNameCategory.text = this
            mainViewModel.listStoryLiveData.observe(viewLifecycleOwner) {
                mainViewModel.initListDetailStoryLiveData(it, this)
            }
            mainViewModel.listStoryDetailLiveData.observe(viewLifecycleOwner) {
                binding.tvCheckNoData.visibility =
                    if (it.size == 0) View.VISIBLE else View.INVISIBLE

                detailStoryAdapter?.listStory = it
            }
        }


    }

    override fun getViewModel(): Class<DetailCategoryViewModel> {
        return DetailCategoryViewModel::class.java
    }

    private fun initAdapter() {
        detailStoryAdapter = DetailStoryAdapter().apply {
            binding.rcItemStory.itemAnimator = null
            binding.rcItemStory.adapter = this
            onItemClickListener = object : DetailStoryAdapter.ItemClickListener {
                override fun onItemClick(story: Story, position: Int) {
                    navigateWithBundle(
                        R.id.fragment_detail_story_top,
                        Bundle().apply {
                            putString(
                                Constant.CATEGORY_STORY,
                                Gson().toJson(story)
                            )
                        })
                }
            }

        }
    }


}