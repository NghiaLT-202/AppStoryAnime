package com.example.appstory88.ui.home.storygoodpassion

import android.os.Bundle
import android.view.View
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingFragment
import com.example.appstory88.databinding.LayoutViewListMoreStoryBinding

class StoryGoodPassionFragment :
    BaseBindingFragment<LayoutViewListMoreStoryBinding, StoryGoodPassionViewModel>() {
    override fun getViewModel(): Class<StoryGoodPassionViewModel> {
        return StoryGoodPassionViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_view_list_more_story
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }
}