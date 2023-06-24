package com.example.appstory88.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryBannerAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.customview.ViewListPreviewStory
import com.example.appstory88.dao.StoryDao
import com.example.appstory88.database.AppDatabase
import com.example.appstory88.databinding.FragmentHomeStoryBinding
import com.example.appstory88.model.Story
import com.google.gson.Gson
import timber.log.Timber

class HomeFragment : BaseBindingFragment<FragmentHomeStoryBinding, MainViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()
    private var storyBannerAdapter: StoryBannerAdapter? = null
    private val listStoryBanner: MutableList<Story> = mutableListOf()


    override fun getLayoutId(): Int {
        return R.layout.fragment_home_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAdapter()
        initListener()
        setupView()
        initData()
    }

    fun setupView() {
        binding.rcFullStory.textCategory = getString(R.string.truy_n_full)
        binding.rcLoveLanguageStory.textCategory = getString(R.string.good_love_language)
        binding.rcFirstHalfStory.textCategory = getString(R.string.good_fairy_tale)
        binding.rcPassionStory.textCategory = getString(R.string.good_passion)
        binding.rcNewUpdateStory.textCategory = getString(R.string.new_story_updated)
    }


    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    private fun initData() {
        viewModel.initData(requireContext())
        viewModel.listStoryLiveData.observe(this) { story ->
            listStory.clear()
            listStoryBanner.clear()
            listStory.addAll(story)
            listStoryBanner.addAll(story)
            viewModel.initlistStoryNewUpdateLiveData(listStory,getString(R.string.ti_u_thuy_t_h_nh_ng))
            viewModel.initlistStoryFullAdapterLiveData(listStory,getString(R.string.ti_u_thuy_t_truy_n_k))
            viewModel.initlistStoryGoodLoveLanguageLiveData(listStory,getString(R.string.ti_u_thuy_t_k_o))
            viewModel.initlistStoryGoodFairyTaleLiveData(listStory,getString(R.string.ti_u_thuy_t_k_ch_t_nh))
            viewModel.initlistStoryGoodPassionLiveData(listStory,getString(R.string.ti_u_thuy_t_phi_u_l_u_m_o_hi_m))
            storyBannerAdapter?.listStory = listStoryBanner
        }
        viewModel.listStoryNewUpdateLiveData.observe(this) { newUpdate ->
            binding.rcNewUpdateStory.listPreviewStory = newUpdate
        }
        viewModel.listStoryFullAdapterLiveData.observe(this) { storyFull ->
            binding.rcFullStory.listPreviewStory = storyFull

        }
        viewModel.listStoryGoodLoveLanguageLiveData.observe(this) { goodLove ->
            binding.rcLoveLanguageStory.listPreviewStory = goodLove
        }
        viewModel.listStoryGoodFairyTaleLiveData.observe(this) { goodFairyTale ->
            binding.rcFirstHalfStory.listPreviewStory = goodFairyTale

        }
        viewModel.listStoryGoodPassionLiveData.observe(this) { goodPassion ->
            binding.rcPassionStory.listPreviewStory = goodPassion

        }
    }


    private fun initListener() {
        binding.viewTopStory.setOnClickListener {
            intentActivity(R.id.fragment_view_top, 0, "")
        }
        binding.viewCategoryStory.setOnClickListener {
            intentActivity(R.id.fragment_view_category, 0, "")
        }
        binding.viewRateStory.setOnClickListener {
            intentActivity(R.id.fragment_view_rate, 0, "")
        }
        binding.viewBookMarkStory.setOnClickListener {
            intentActivity(R.id.fragment_view_bookmark, 0, "")

        }


    }


    private fun initAdapter() {
        storyBannerAdapter()
        storyGoodFairyTaleAdapter()
        storyNewUpdateAdapter()
        storyFullAdapter()
        storyGoodLoveLanguageAdapter()
        storyGoodFairyTaleAdapter()
        storyGoodPassionAdapter()


    }

    private fun storyBannerAdapter() {
        storyBannerAdapter = StoryBannerAdapter().apply {
            binding.rcItemStoryBanner.adapter = this
            iclick = object : StoryBannerAdapter.IClick {
                override fun clickItem(story: Story, position: Int) {
                    intentActivityAndData(position)


                }
            }
        }

    }

    private fun storyNewUpdateAdapter() {
        binding.rcNewUpdateStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {
                intentActivityAndData(position)
            }
            override fun onClickShowMore(name: String) {
                intentActivity(R.id.fragment_view_more_story, 0, name)
            }
        }


    }

    private fun storyFullAdapter() {
        binding.rcFullStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {
                intentActivityAndData(position)
            }
            override fun onClickShowMore(name: String) {
                intentActivity(R.id.fragment_view_more_story, 0, name)
            }
        }

    }

    private fun storyGoodLoveLanguageAdapter() {
        binding.rcLoveLanguageStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {
                intentActivityAndData(position)

            }

            override fun onClickShowMore(name: String) {
                intentActivity(R.id.fragment_view_more_story, 0, name)

            }


        }
    }

    private fun storyGoodFairyTaleAdapter() {
        binding.rcFirstHalfStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {
                intentActivityAndData(position)

            }
            override fun onClickShowMore(name: String) {
                intentActivity(R.id.fragment_view_more_story, 0, name)


            }


        }

    }


    private fun storyGoodPassionAdapter() {

        binding.rcPassionStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {

                intentActivityAndData(position)

            }

            override fun onClickShowMore(name: String) {
                Toast.makeText(requireContext(), ""+name, Toast.LENGTH_SHORT).show()

                intentActivity(R.id.fragment_view_more_story, 0, name)
            }


        }

    }


    private fun intentActivityAndData(position: Int) {
        val bundle = Bundle()
        bundle.putString(
            Constant.KEY_DETAIL_STORY,
            Gson().toJson(storyBannerAdapter?.listStory?.get(position))
        )
        (requireActivity() as MainActivity).navController?.navigate(
            R.id.fragment_detail_story,
            bundle
        )
    }

    private fun intentActivity(id: Int, position: Int, nameCategory: String) {
        val bundle = Bundle()
        bundle.putString(Constant.CATEGORY_STORY, listStory[position].nameCategory)

        (requireActivity() as MainActivity).navController?.navigate(id, null)

    }


}
