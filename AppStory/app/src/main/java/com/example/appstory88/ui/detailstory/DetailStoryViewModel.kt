package com.example.appstory88.ui.detailstory

import androidx.lifecycle.MutableLiveData
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.model.Story

class DetailStoryViewModel : BaseViewModel() {
    var listStoryLiveData = MutableLiveData<MutableList<Story>>()


    override fun onCleared() {
        super.onCleared()
    }

    fun getAllListStory() {
        var storyList: MutableList<Story> = mutableListOf()

        listStoryLiveData.postValue(storyList)

    }


}