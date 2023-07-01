package com.example.appstory88.ui.describestory

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemCategoryDetailAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.databinding.FragmentDetailStoryBinding
import com.example.appstory88.model.Story
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.utils.StatusBarUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailStoryFragment :
    BaseBindingFragment<FragmentDetailStoryBinding, DetailStoryViewModel>() {
    private var story: Story? = null

    var checkBookmark: Boolean = false


    private var itemCategoryDetailAdapter: ItemCategoryDetailAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        StatusBarUtils.makeStatusBarLight(requireActivity(), ContextCompat.getColor(requireActivity(),R.color.statusbarlight))
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
        arguments?.getString(Constant.KEY_DETAIL_STORY)?.let { storyJson ->
            story = Gson().fromJson<Story>(storyJson, object : TypeToken<Story>() {}.type)
            initData()
        }


    }

    override fun getViewModel(): Class<DetailStoryViewModel> {
        return DetailStoryViewModel::class.java
    }

    private fun initListener() {
        binding.imBack.setOnClickListener {
            (requireActivity() as MainActivity).navController?.popBackStack()
        }
        binding.tvReadStory.setOnClickListener {
            (requireActivity() as MainActivity).navController?.navigate(
                R.id.fragment_read_story,
                Bundle().apply {
                    putString(
                        Constant.KEY_DETAIL_STORY,
                        Gson().toJson(story)
                    )
                }
            )
        }
        binding.tvBookmark.setOnClickListener {
            with(binding){
            if (!checkBookmark) {
                checkBookmark = true
                imDone.setImageResource(R.drawable.baseline_done_24)
                tvBookmark.setTextColor(resources.getColor(R.color.yellow))
                story?.let { it1 -> viewModel.insertStory(it1, requireContext()) }
            } else {
                checkBookmark = false
                imDone.setImageResource(R.drawable.baseline_playlist_add_24)

                tvBookmark.setTextColor(resources.getColor(R.color.white))
                story?.let { it1 -> viewModel.deleteStory(it1.nameStory, requireContext()) }
            }
            }
        }
    }

    private fun initData() {
        mainViewModel?.listStoryLiveData?.observe(viewLifecycleOwner) {
            story?.nameStory?.let { it1 -> mainViewModel.initlistCategoryData(it, it1) }
        }
        mainViewModel.listCategoryData.observe(viewLifecycleOwner){
            itemCategoryDetailAdapter?.listCategoryStory = it

        }

        story?.let {
            with(binding) {
                Glide.with(requireContext()).load(it.imageStory).into(imStory)
                tvNameStory.text = it.nameStory
                viewStar.numberStar = it.numberStar
                tvValueView.text = it.numberView.toString()
                tvValueChapterNumber.text = it.chapterSum.toString()
                tvValueAuthur.text = it.nameAuthor
                tvValueStatus.text = it.status.toString()
                tvValueDescribe.text = it.describe
            }

        }

    }


}