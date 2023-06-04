package com.example.appstory88.ui.home.bookmark

import android.os.Bundle
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.BookMarkActivityBinding

class BookmarkActivity: BaseBindingActivity<BookMarkActivityBinding, BookmarkViewModel>() {
    override fun getLayoutId(): Int {
        return R .layout.book_mark_activity
    }

    override fun setupView(savedInstanceState: Bundle?) {
    }

    override fun setupData() {
    }

    override fun getViewModel(): Class<BookmarkViewModel> {
        return BookmarkViewModel::class.java
    }
}