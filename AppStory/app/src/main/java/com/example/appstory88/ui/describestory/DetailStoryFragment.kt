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
    private val listBookmarkStory: MutableList<Story> = mutableListOf()

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
        viewModel.getAllBookmark()
        mainViewModel.listBookmarkStory.observe(viewLifecycleOwner){
            listBookmarkStory.clear()
            listBookmarkStory.addAll(it)
            Timber.e("ltnghia listBookmarkStory " +listBookmarkStory.size)

        }
        initData()
        with(binding) {
            for (itemStory in listBookmarkStory){
                Timber.e("ltnghia contains "+itemStory.nameStory +" Story  "+story?.nameStory )

                if (itemStory.nameStory==story?.nameStory){
                    Timber.e("ltnghia contains "+itemStory.nameStory  )

                    checkBookmark=true
                    break
                }else {
                    Timber.e("ltnghia contains false"  )

                    checkBookmark=false

                }
            }
            if (checkBookmark){
                Timber.e("ltnghia contains true"  )
                imDone.setImageResource(R.drawable.baseline_done_24)
                tvBookmark.setTextColor(resources.getColor(R.color.yellow))
            }else{
                Timber.e("ltnghia contains false"  )

                imDone.setImageResource(R.drawable.baseline_playlist_add_24)
                tvBookmark.setTextColor(resources.getColor(R.color.white))
            }
        }





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

                    checkBook(true,R.drawable.baseline_done_24,resources.getColor(R.color.yellow))
                    Timber.e("ltnghia true " )

                    story?.let { it1 -> viewModel.insertStory(it1) }


                } else {
                    checkBook(false,R.drawable.baseline_playlist_add_24,resources.getColor(R.color.white))
                    Timber.e("ltnghia false " )

                    story?.let { it1 -> viewModel.deleteStory(it1.nameStory)
                    }
                }
            }
        }
    }
    fun checkBook(check:Boolean, image:Int, color:Int){
        checkBookmark = check
        with(binding){
            imDone.setImageResource(image)
            tvBookmark.setTextColor(color)
        }

    }

    private fun initData() {
        arguments?.getString(Constant.KEY_DETAIL_STORY)?.let { storyJson ->
            story = Gson().fromJson<Story>(storyJson, object : TypeToken<Story>() {}.type)
        }

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