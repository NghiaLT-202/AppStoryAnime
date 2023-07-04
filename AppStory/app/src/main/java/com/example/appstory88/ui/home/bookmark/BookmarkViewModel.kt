package com.example.appstory88.ui.home.bookmark

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.data.dao.StoryDao
import com.example.appstory88.data.database.AppDatabase
import com.example.appstory88.data.model.Story
import com.example.appstory88.repository.StoryRepository
import timber.log.Timber

class BookmarkViewModel : BaseViewModel() {
    private val storyRepository: StoryRepository?=null

     val listBookmarkStory = MutableLiveData<MutableList<Story>>()



    fun deleteStory() {
        storyRepository?.deleteAllListBookmark()
    }
    fun getAllBookmark() {
        Timber.e("ltnghia getAllBookmark"+storyRepository?.getAllBookmark().toString())
        listBookmarkStory.postValue(storyRepository?.getAllBookmark())


    }

}


