package com.example.appstory88.ui.home.ratestory

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.adapter.RateStoryAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentRateStoryBinding
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.utils.StatusBarUtils
import com.google.gson.Gson

class RateStoryFragment : BaseBindingFragment<FragmentRateStoryBinding, RateStoryViewModel>() {
    private var rateStoryAdapter: RateStoryAdapter? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_rate_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        StatusBarUtils.makeStatusBarLight(requireActivity(), ContextCompat.getColor(requireActivity(),R.color.white))

        initAdapter()
        setupData()
    }
    private fun setupData() {
        mainViewModel.listStoryLiveData.observe(viewLifecycleOwner) { story ->
            mainViewModel?.initListRateStoryLiveData(story)

        }
        mainViewModel.listStoryRateLiveData.observe(viewLifecycleOwner) {
            rateStoryAdapter?.listStory = it

        }

    }

    private fun initAdapter() {
        rateStoryAdapter = RateStoryAdapter().apply {
//            rateStoryAdapter?.setHasStableIds(false)
            binding.rcItemStory.itemAnimator=null
            binding.rcItemStory.adapter = this
            onItemClickListener = object : RateStoryAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                    navigateWithBundle(R.id.fragment_detail_story,Bundle().apply {
                        putString(
                            Constant.KEY_DETAIL_STORY,
                            Gson().toJson(rateStoryAdapter?.listStory?.get(position))
                        )
                    })
                }
            }

        }
    }


    override fun getViewModel(): Class<RateStoryViewModel> {
        return RateStoryViewModel::class.java
    }


}