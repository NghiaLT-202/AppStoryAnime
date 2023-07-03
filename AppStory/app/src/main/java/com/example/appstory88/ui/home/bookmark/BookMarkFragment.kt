package com.example.appstory88.ui.home.bookmark

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryBookmarkAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.data.model.Story
import com.example.appstory88.databinding.FragmentBookMarkStoryBinding
import com.example.appstory88.utils.StatusBarUtils
import com.google.gson.Gson

class BookMarkFragment : BaseBindingFragment<FragmentBookMarkStoryBinding, BookmarkViewModel>() {
    private var storyBookmarkAdapter: StoryBookmarkAdapter? = null
    private val listBookmarkStory: MutableList<Story> = mutableListOf()


    override fun getLayoutId(): Int {
        return R.layout.fragment_book_mark_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        StatusBarUtils.makeStatusBarLight(
            requireActivity(),
            ContextCompat.getColor(requireActivity(), R.color.white)
        )
        initListener()

        initAdapter()
        initData()

    }

    private fun initListener() {
        binding.tvDeleteBookmark.setOnClickListener {
            listBookmarkStory.clear()
            viewModel.deleteStory(requireContext())
            binding.tvCheckNoData.visibility = View.VISIBLE

            storyBookmarkAdapter?.listStory = listBookmarkStory
        }
    }

    private fun initData() {
        mainViewModel.getAllBookmark(requireContext())
        mainViewModel.listBookmarkStory.observe(viewLifecycleOwner) {
            listBookmarkStory.clear()
            listBookmarkStory.addAll(it)
            binding.tvCheckNoData.visibility =
                if (listBookmarkStory.size == 0) View.VISIBLE else View.INVISIBLE
            storyBookmarkAdapter?.listStory = listBookmarkStory

        }
    }

    private fun initAdapter() {
        storyBookmarkAdapter = StoryBookmarkAdapter().apply {
            binding.rcItemStory.itemAnimator = null
            binding.rcItemStory.adapter = this
            iclick = object : StoryBookmarkAdapter.IClick {
                override fun clickItem(story: Story, position: Int) {
                    navigateWithBundle(R.id.fragment_detail_story, Bundle().apply {
                        putString(
                            Constant.KEY_DETAIL_STORY,
                            Gson().toJson(storyBookmarkAdapter?.listStory?.get(position))
                        )
                    })
                }
            }

        }
    }

    override fun getViewModel(): Class<BookmarkViewModel> {
        return BookmarkViewModel::class.java
    }


}