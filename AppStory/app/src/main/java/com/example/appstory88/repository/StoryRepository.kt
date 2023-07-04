package com.example.appstory88.repository

import com.example.appstory88.data.database.AppDatabase
import com.example.appstory88.data.model.Story
import timber.log.Timber

class StoryRepository {
    private val storyDataBase: AppDatabase? = null
    fun insertStory(story: Story?) {
        Timber.e("ltnghia insertStory")

        story?.let { storyDataBase?.storyDao()?.insertStory(it) }
    }

    fun deleteBookmarkWithName(name: String?) {
        storyDataBase?.storyDao()?.deleteBookmarkWithName(name)
    }

    fun deleteAllListBookmark() {
        storyDataBase?.storyDao()?.deleteAllListBookmark()
    }

    fun getAllBookmark(): MutableList<Story>? {
        Timber.e("ltnghia getAllBookmark")
        return storyDataBase?.storyDao()?.getAllBookmark()
    }

}