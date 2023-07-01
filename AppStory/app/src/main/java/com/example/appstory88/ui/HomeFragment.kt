package com.example.appstory88.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryBannerAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.customview.ViewListPreviewStory

import com.example.appstory88.databinding.FragmentHomeStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.utils.StatusBarUtils
import com.google.gson.Gson

class HomeFragment : BaseBindingFragment<FragmentHomeStoryBinding, HomeViewModel>() {
    private val listStory: MutableList<Story> = mutableListOf()
    private var storyBannerAdapter: StoryBannerAdapter? = null
    private val listStoryBanner: MutableList<Story> = mutableListOf()

    override fun getLayoutId(): Int {
        return R.layout.fragment_home_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {

        StatusBarUtils.makeStatusBarLight(requireActivity(), ContextCompat.getColor(requireActivity(),R.color.white))

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


    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    private fun initData() {
        mainViewModel.listStoryLiveData.observe(viewLifecycleOwner) { story ->
            listStory.clear()
            listStoryBanner.clear()
            listStory.addAll(story)
            listStoryBanner.addAll(story)
            with(mainViewModel){
                initlistStoryNewUpdateLiveData(listStory,getString(R.string.ti_u_thuy_t_h_nh_ng))
                initlistStoryFullAdapterLiveData(listStory,getString(R.string.ti_u_thuy_t_truy_n_k))
                initlistStoryGoodLoveLanguageLiveData(listStory,getString(R.string.ti_u_thuy_t_k_o))
                initlistStoryGoodFairyTaleLiveData(listStory,getString(R.string.ti_u_thuy_t_k_ch_t_nh))
                initlistStoryGoodPassionLiveData(listStory,getString(R.string.ti_u_thuy_t_phi_u_l_u_m_o_hi_m))
            }

            storyBannerAdapter?.listStory = listStoryBanner
        }
        mainViewModel.listStoryNewUpdateLiveData.observe(viewLifecycleOwner) { newUpdate ->
            binding.rcNewUpdateStory.listPreviewStory = newUpdate
        }
        mainViewModel.listStoryFullAdapterLiveData.observe(viewLifecycleOwner) { storyFull ->
            binding.rcFullStory.listPreviewStory = storyFull

        }
        mainViewModel.listStoryGoodLoveLanguageLiveData.observe(viewLifecycleOwner) { goodLove ->
            binding.rcLoveLanguageStory.listPreviewStory = goodLove
        }
        mainViewModel.listStoryGoodFairyTaleLiveData.observe(viewLifecycleOwner) { goodFairyTale ->
            binding.rcFirstHalfStory.listPreviewStory = goodFairyTale

        }
        mainViewModel.listStoryGoodPassionLiveData.observe(viewLifecycleOwner) { goodPassion ->
            binding.rcPassionStory.listPreviewStory = goodPassion

        }
    }


    private fun initListener() {
        binding.viewTopStory.setOnClickListener {
            intentActivity(R.id.fragment_view_top, "")
        }
        binding.viewCategoryStory.setOnClickListener {
            intentActivity(R.id.fragment_view_category,  "")
        }
        binding.viewRateStory.setOnClickListener {
            intentActivity(R.id.fragment_view_rate, "")
        }
        binding.viewBookMarkStory.setOnClickListener {
            intentActivity(R.id.fragment_view_bookmark, "")

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
                    intentActivityAndData(story)


                }
            }
        }

    }

    private fun storyNewUpdateAdapter() {
        binding.rcNewUpdateStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {
                intentActivityAndData(story)
            }
            override fun onClickShowMore(name: String) {
                intentActivity(R.id.fragment_view_more_story,  getString(R.string.ti_u_thuy_t_h_nh_ng))
            }
        }


    }

    private fun storyFullAdapter() {
        binding.rcFullStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {
                intentActivityAndData(story)
            }
            override fun onClickShowMore(name: String) {
                intentActivity(R.id.fragment_view_more_story, getString(R.string.ti_u_thuy_t_truy_n_k))
            }
        }

    }

    private fun storyGoodLoveLanguageAdapter() {
        binding.rcLoveLanguageStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {
                intentActivityAndData(story)

            }

            override fun onClickShowMore(name: String) {
                intentActivity(R.id.fragment_view_more_story, getString(R.string.ti_u_thuy_t_k_o))

            }


        }
    }

    private fun storyGoodFairyTaleAdapter() {
        binding.rcFirstHalfStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {
                intentActivityAndData(story)

            }
            override fun onClickShowMore(name: String) {
                intentActivity(R.id.fragment_view_more_story,  getString(R.string.ti_u_thuy_t_k_ch_t_nh))


            }


        }

    }


    private fun storyGoodPassionAdapter() {

        binding.rcPassionStory.iClickListener = object : ViewListPreviewStory.IClickPreview {
            override fun onClick(story: Story, position: Int) {

                intentActivityAndData(story)

            }

            override fun onClickShowMore(name: String) {
                Toast.makeText(requireContext(), ""+getString(R.string.ti_u_thuy_t_phi_u_l_u_m_o_hi_m), Toast.LENGTH_SHORT).show()
                intentActivity(R.id.fragment_view_more_story,  getString(R.string.ti_u_thuy_t_phi_u_l_u_m_o_hi_m))
            }
        }

    }


    private fun     intentActivityAndData(story: Story) {

        (requireActivity() as MainActivity).navController?.navigate(
            R.id.fragment_detail_story,
            Bundle().apply {
                putString(
                    Constant.KEY_DETAIL_STORY,
                    Gson().toJson(story)
                )
            }
        )
    }

    private fun intentActivity(id: Int,  nameCategory: String) {
        (requireActivity() as MainActivity).navController?.navigate(id,  Bundle().apply { putString(Constant.CATEGORY_STORY, nameCategory) })


    }


}
