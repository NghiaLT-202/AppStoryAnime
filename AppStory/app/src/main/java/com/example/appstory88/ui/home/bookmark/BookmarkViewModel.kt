package com.example.appstory88.ui.home.bookmark

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.data.dao.StoryDao
import com.example.appstory88.data.database.AppDatabase
import com.example.appstory88.data.model.Story

class BookmarkViewModel : BaseViewModel() {
    var storyDao : StoryDao?=null




    fun deleteStory(context: Context) {
        storyDao = AppDatabase.getInstanceDataBase(context).storyDao()
        storyDao?.deleteAllListBookmark()
    }

}