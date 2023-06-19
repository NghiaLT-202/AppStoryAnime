package com.example.appstory88.ui.home.ratestory

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.appstory88.R
import com.example.appstory88.adapter.RateStoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentRateStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.ui.MainViewModel
import com.google.gson.Gson

class RateStoryFragment : BaseBindingFragment<FragmentRateStoryBinding, RateStoryViewModel>() {
    //    private val listStory: MutableList<Story> = mutableListOf()
    private var mainViewModel: MainViewModel? = null
    private var rateStoryAdapter: RateStoryAdapter? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_rate_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAdapter()
        setupData()
    }



     fun setupData() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel?.initData(requireContext())
        mainViewModel?.listStoryLiveData?.observe(this) { story ->
            mainViewModel?.initListRateStoryLiveData(story)
            rateStoryAdapter?.listStory = story

        }

    }

    private fun initAdapter() {
        rateStoryAdapter = RateStoryAdapter().apply {
            binding.rcItemStory.adapter = this
            onItemClickListener = object : RateStoryAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                    intentActivityAndData(listStory[position],position)

                }
            }

        }
    }


    override fun getViewModel(): Class<RateStoryViewModel> {
        return RateStoryViewModel::class.java
    }

    private fun intentActivityAndData(story: Story, position: Int) {
        val bundle = Bundle()
        bundle.putString(
            Constant.KEY_DETAIL_STORY,
            Gson().toJson(rateStoryAdapter?.listStory?.get(position))
        )
        (requireActivity() as MainActivity).navController?.navigate(
            R.id.fragment_detail_story,
            bundle
        )

    }
}