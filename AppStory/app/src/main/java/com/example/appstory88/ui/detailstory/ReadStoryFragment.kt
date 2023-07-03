package com.example.appstory88.ui.detailstory

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant

import com.example.appstory88.databinding.FragmentRedStoryBinding
import com.example.appstory88.data.model.Story
import com.example.appstory88.utils.StatusBarUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ReadStoryFragment :
    BaseBindingFragment<FragmentRedStoryBinding, ReadStoryViewModel>() {
    private var story: Story? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_red_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        StatusBarUtils.makeStatusBarLight(requireActivity(), ContextCompat.getColor(requireActivity(),R.color.white))

        initListener()
        initData()

    }

    private fun initListener() {

        binding.imBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }


    override fun getViewModel(): Class<ReadStoryViewModel> {
        return ReadStoryViewModel::class.java
    }

    @SuppressLint("SetTextI18n")
    private fun initData() {
        Gson().fromJson<Story>(arguments?.getString(Constant.KEY_DETAIL_STORY), object : TypeToken<Story>() {}.type).let {
            with(binding){
                tvNameStory.text = it.nameStory
                tvDescribeStory.text = it.describe
                tvNamechapter.text = getString(R.string.ch_ng) + it.chapter
            }

        }


    }
}