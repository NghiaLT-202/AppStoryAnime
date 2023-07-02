package com.example.appstory88.ui.describestory

import android.content.Context
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.data.dao.StoryDao
import com.example.appstory88.data.database.AppDatabase
import com.example.appstory88.data.model.Story

class DetailStoryViewModel : BaseViewModel() {
    var storyDao : StoryDao?=null

    fun insertStory(story: Story, context: Context){
        storyDao= AppDatabase.getInstanceDataBase(context).storyDao()
        storyDao?.insertStory(story)
    }

    fun deleteStory(nameStory:String, context: Context) {
        storyDao = AppDatabase.getInstanceDataBase(context).storyDao()
        storyDao?.deleteBookmark(nameStory)
    }
}