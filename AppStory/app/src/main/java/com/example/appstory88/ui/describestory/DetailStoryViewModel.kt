package com.example.appstory88.ui.describestory

import androidx.lifecycle.MutableLiveData
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.data.model.Story
import com.example.appstory88.repository.StoryRepository
import timber.log.Timber

class DetailStoryViewModel : BaseViewModel() {
    private var storyRepository: StoryRepository = StoryRepository()


    fun insertStory(story: Story) {
        Timber.e("ltnghia insertStory")

        storyRepository.insertStory(story)
    }

    fun deleteStory(nameStory: String) {
        storyRepository.deleteBookmarkWithName(nameStory)
    }


}