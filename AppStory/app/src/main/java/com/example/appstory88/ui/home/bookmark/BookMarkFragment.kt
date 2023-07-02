package com.example.appstory88.ui.home.bookmark

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.appstory88.R
import com.example.appstory88.adapter.StoryBookmarkAdapter
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.commom.Constant
import com.example.appstory88.data.dao.StoryDao
import com.example.appstory88.data.database.AppDatabase
import com.example.appstory88.data.model.Story
import com.example.appstory88.databinding.FragmentBookMarkStoryBinding
import com.example.appstory88.ui.MainActivity
import com.example.appstory88.utils.StatusBarUtils
import com.google.gson.Gson

class BookMarkFragment : BaseBindingFragment<FragmentBookMarkStoryBinding, BookmarkViewModel>() {
    var storyDao: StoryDao? = null
    private var storyBookmarkAdapter: StoryBookmarkAdapter? = null

    private val listBookmarkStory: MutableList<Story> = mutableListOf()


    override fun getLayoutId(): Int {
        return R.layout.fragment_book_mark_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        StatusBarUtils.makeStatusBarLight(requireActivity(), ContextCompat.getColor(requireActivity(),R.color.white))

        initAdapter()
        initData()

    }

    private fun initData() {
        AppDatabase.getInstanceDataBase(requireContext()).storyDao().getAllStory().let { listBookmarkStory.addAll(it) }
        storyBookmarkAdapter?.listStory = listBookmarkStory
    }

    private fun initAdapter() {
        storyBookmarkAdapter = StoryBookmarkAdapter().apply {
            binding.rcItemStory.adapter = this
            iclick = object : StoryBookmarkAdapter.IClick {
                override fun clickItem(story: Story, position: Int) {
                    intentActivityAndData(position)

                }
            }

        }
    }

    override fun getViewModel(): Class<BookmarkViewModel> {
        return BookmarkViewModel::class.java
    }

    private fun intentActivityAndData(position: Int) {

        Bundle().let {
            it.putString(
                Constant.KEY_DETAIL_STORY,
                Gson().toJson(storyBookmarkAdapter?.listStory?.get(position))
            )
            (requireActivity() as MainActivity).navController?.navigate(
                R.id.fragment_detail_story,
                it
            )
        }


    }
}