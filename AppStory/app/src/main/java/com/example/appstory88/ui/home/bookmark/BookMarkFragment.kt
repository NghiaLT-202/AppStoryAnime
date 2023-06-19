package com.example.appstory88.ui.home.bookmark

import android.os.Bundle
import android.view.View
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.databinding.FragmentBookMarkStoryBinding

class BookMarkFragment : BaseBindingFragment<FragmentBookMarkStoryBinding, BookmarkViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_book_mark_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
    }



    override fun getViewModel(): Class<BookmarkViewModel> {
        return BookmarkViewModel::class.java
    }
}