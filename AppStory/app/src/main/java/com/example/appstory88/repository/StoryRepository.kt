package com.example.appstory88.repository

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Database
import com.example.appstory88.App
import com.example.appstory88.data.database.AppDatabase
import com.example.appstory88.data.model.Story
import timber.log.Timber

class StoryRepository {
    private  var storyDataBase: AppDatabase
    constructor(){
        storyDataBase=AppDatabase.getInstanceDataBase(App.context)
    }
    fun insertStory(story: Story) {
        Timber.e("ltnghia insertStory")
        story.let { storyDataBase.storyDao().insertStory(it) }
    }

    fun deleteBookmarkWithName(name: String) {
        storyDataBase.storyDao().deleteBookmarkWithName(name)
    }

    fun deleteAllListBookmark() {
        storyDataBase.storyDao().deleteAllListBookmark()
    }

    fun getAllBookmark(): MutableList<Story> {
        return storyDataBase.storyDao().getAllBookmark()
    }

}