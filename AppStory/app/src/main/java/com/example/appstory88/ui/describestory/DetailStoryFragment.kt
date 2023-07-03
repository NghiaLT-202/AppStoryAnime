package com.example.appstory88.ui.describestory

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.appstory88.R
import com.example.appstory88.adapter.ItemCategoryDetailAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.data.model.Story
import com.example.appstory88.databinding.FragmentDetailStoryBinding
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.utils.StatusBarUtils
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import timber.log.Timber
import java.text.NumberFormat
import java.util.Locale

class DetailStoryFragment :
    BaseBindingFragment<FragmentDetailStoryBinding, DetailStoryViewModel>() {
    private var story: Story? = null

    var checkBookmark: Boolean = false


    private var itemCategoryDetailAdapter: ItemCategoryDetailAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        StatusBarUtils.makeStatusBarLight(
            requireActivity(),
            ContextCompat.getColor(requireActivity(), R.color.statusbarlight)
        )
        initListener()
        initAdapter()
        setupData()
    }


    private fun initAdapter() {
        itemCategoryDetailAdapter = ItemCategoryDetailAdapter().apply {
            binding.rcCategory.itemAnimator = null

            binding.rcCategory.adapter = this
            FlexboxLayoutManager(requireContext()).apply {
                flexWrap = FlexWrap.WRAP
                binding.rcCategory.layoutManager = this
            }

            onItemClickListener = object : ItemCategoryDetailAdapter.ItemClickListener {
                override fun onItemClick(position: Int) {
                    navigateWithBundle(
                        R.id.fragment_detail_story_top,
                        Bundle().apply {
                            putString(
                                Constant.CATEGORY_STORY,
                                listCategoryStory[position]
                            )
                        })
                }

            }
        }
    }

    private fun setupData() {
        arguments?.getString(Constant.KEY_DETAIL_STORY)?.let { storyJson ->
            story = Gson().fromJson<Story>(storyJson, object : TypeToken<Story>() {}.type)
            with(binding) {
                if (story?.checkBookmark == true) {
                    imDone.setImageResource(R.drawable.baseline_done_24)
                    tvBookmark.setTextColor(resources.getColor(R.color.yellow))
                    checkBookmark=true

                } else {
                    imDone.setImageResource(R.drawable.baseline_playlist_add_24)
                    tvBookmark.setTextColor(resources.getColor(R.color.white))
                }
            }
            initData()
        }
        mainViewModel.getAllBookmark(requireContext())


    }

    override fun getViewModel(): Class<DetailStoryViewModel> {
        return DetailStoryViewModel::class.java
    }

    private fun initListener() {

        with(binding) {
            imBack.setOnClickListener {
                (requireActivity() as MainActivity).navController?.popBackStack()
            }
            tvReadStory.setOnClickListener {
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
            tvBookmark.setOnClickListener {
                if (!checkBookmark) {
                    checkBook()
                    story?.let { it1 -> viewModel.insertStory(it1, requireContext()) }
                } else {
                    checkBookmark = false
                    imDone.setImageResource(R.drawable.baseline_playlist_add_24)
                    tvBookmark.setTextColor(resources.getColor(R.color.white))
                    story?.checkBookmark = checkBookmark
                    story?.let { it1 -> viewModel.deleteStory(it1.nameStory, requireContext()) }
                }
            }
        }
    }

    private fun FragmentDetailStoryBinding.checkBook() {
        checkBookmark = true
        imDone.setImageResource(R.drawable.baseline_done_24)
        tvBookmark.setTextColor(resources.getColor(R.color.yellow))
        story?.checkBookmark = checkBookmark
    }

    private fun initData() {


        story?.let {
            with(binding) {
                Glide.with(requireContext()).load(it.imageStory).into(imStory)
                Glide.with(requireContext()).load(it.imageStory).into(bgView)
                tvNameStory.text = it.nameStory
                viewStar.numberStar = it.numberStar
                tvValueView.text = NumberFormat.getNumberInstance(Locale.US).format(it.numberView)
                tvValueChapterNumber.text = it.chapterSum.toString()
                tvValueAuthur.text = it.nameAuthor
                if (it.status) tvValueStatus.text =
                    getString(R.string.ang_ph_t_h_nh) else tvValueStatus.text = getString(
                    R.string.ang_ra
                )
                tvValueDescribe.text = it.describe
                itemCategoryDetailAdapter?.listCategoryStory = it.nameCategory

            }

        }


    }


}