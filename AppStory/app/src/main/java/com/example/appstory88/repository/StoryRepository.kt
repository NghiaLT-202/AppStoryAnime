package com.example.appstory88.repository

import com.example.appstory88.data.database.AppDatabase
import com.example.appstory88.data.model.Story
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Callable

class StoryRepository {
    private val storyDataBase: AppDatabase? = null
    fun insertStory(story: Story?) {
        Completable.fromAction { story?.let { storyDataBase?.storyDao()?.insertStory(it) }
        }.subscribeOn(Schedulers.io()).subscribe()
    }
    fun deleteBookmarkWithName(name: String?) {
        Completable.fromAction {
            storyDataBase?.storyDao()?.deleteBookmarkWithName(name)
        }.subscribeOn(Schedulers.io()).subscribe()
    }

    fun deleteAllListBookmark() {
        Completable.fromAction {
            storyDataBase?.storyDao()?.deleteAllListBookmark()
        }.subscribeOn(Schedulers.io()).subscribe()
    }


}