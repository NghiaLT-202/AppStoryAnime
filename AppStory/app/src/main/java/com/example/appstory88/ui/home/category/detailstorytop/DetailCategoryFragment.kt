package com.example.appstory88.ui.home.topstory.detailstorytop

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.adapter.DetailStoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.data.model.ItemCategory
import com.example.appstory88.data.model.Story
import com.example.appstory88.databinding.FragmentDetailStoryTopBinding
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.utils.StatusBarUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailCategoryFragment :
    BaseBindingFragment<FragmentDetailStoryTopBinding, DetailCategoryViewModel>() {
    private var detailStoryAdapter: DetailStoryAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail_story_top
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        StatusBarUtils.makeStatusBarLight(requireActivity(), ContextCompat.getColor(requireActivity(),R.color.white))

        setupViews()
        setupData()
    }

    private fun setupViews() {
        initAdapter()
    }

    private fun setupData() {

        Gson().fromJson<ItemCategory>(
            arguments?.getString(Constant.CATEGORY_STORY),
            object : TypeToken<ItemCategory>() {}.type
        ).let {
            binding.tvNameCategory.text = it.name
            detailStoryAdapter?.listStory = it.listStory

        }


    }

    override fun getViewModel(): Class<DetailCategoryViewModel> {
        return DetailCategoryViewModel::class.java
    }

    private fun initAdapter() {
        detailStoryAdapter = DetailStoryAdapter().apply {
            binding.rcItemStory.adapter = this
            onItemClickListener = object : DetailStoryAdapter.ItemClickListener {
                override fun onItemClick(story: Story, position: Int) {
                    intentActivityAndData(story)
                }
            }

        }
    }

    private fun intentActivityAndData(story: Story) {
        story.let {
            Bundle().let {
                it.putString(
                    Constant.KEY_DETAIL_STORY,
                    Gson().toJson(story)
                )
                (requireActivity() as MainActivity).navController?.navigate(
                    R.id.fragment_detail_story,
                    it
                )
            }

        }


    }

}