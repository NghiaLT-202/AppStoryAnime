package com.example.appstory88.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.appstory88.R
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.model.Story
import java.util.Random

class MainViewModel : BaseViewModel() {
    val TYPE_NEW_STORY = "New story updated"
    val TYPE_FULL_STORY = "Story full"
    val TYPE_GOOD_LOVE_STORY = "Good love language"
    val TYPE_FAIRY_TALE_STORY = "Good fairy tale"
    val TYPE_GOOD_PASSION_STORY = "Good passion"
    val listStoryLiveData = MutableLiveData<MutableList<Story>>()
    val listCategoryLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryMoreLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryDetailLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryRateLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryNewUpdateLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryFullAdapterLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryGoodLoveLanguageLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryGoodFairyTaleLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryGoodPassionLiveData = MutableLiveData<MutableList<Story>>()


    override fun onCleared() {
        super.onCleared()
    }


    fun initlistStoryNewUpdateLiveData(list: MutableList<Story>) {


        listStoryNewUpdateLiveData.postValue(list.filter { it.nameCategory == TYPE_NEW_STORY }
            .toMutableList())


    }

    fun initlistStoryFullAdapterLiveData(list: MutableList<Story>) {
        listStoryFullAdapterLiveData.postValue(list.filter { it.nameCategory == TYPE_FULL_STORY }
            .toMutableList())
    }

    fun initlistStoryGoodLoveLanguageLiveData(list: MutableList<Story>) {
        listStoryGoodLoveLanguageLiveData.postValue(list.filter {
            it.nameCategory == TYPE_GOOD_LOVE_STORY
        }
            .toMutableList())
    }

    fun initlistStoryGoodFairyTaleLiveData(list: MutableList<Story>) {
        listStoryGoodFairyTaleLiveData.postValue(list.filter {
            it.nameCategory == TYPE_FAIRY_TALE_STORY
        }
            .toMutableList())
    }

    fun initlistStoryGoodPassionLiveData(list: MutableList<Story>) {
        listStoryGoodPassionLiveData.postValue(list.filter {
            it.nameCategory == TYPE_GOOD_PASSION_STORY
        }.toMutableList())
    }

    fun initlistStoryLiveData(list: MutableList<Story>, type: String) {
        listStoryMoreLiveData.postValue(list.filter {
            it.nameCategory == type
        }.toMutableList())
    }

    fun initlistDetailStoryLiveData(list: MutableList<Story>, type: String) {
        listStoryDetailLiveData.postValue(list.filter {
            it.nameCategory == type
        }.toMutableList())
    }

    fun initlistCategoryDetailStoryLiveData(list: MutableList<Story>, type: String) {
        listCategoryLiveData.postValue(list.filter {
            it.nameCategory== type
        }.toMutableList())
    }

    fun initListRateStoryLiveData(list: MutableList<Story>) {
        list.sortWith(compareByDescending(Story::numberView))
        listStoryRateLiveData.postValue(list)
    }

    fun initData(context: Context) {
        val listName = context.resources.getStringArray(R.array.list_name_story)
        val listContent = context.resources.getStringArray(R.array.list_content_story)
        val listCategory = context.resources.getStringArray(R.array.list_category_story)
        val listImage = context.resources.getStringArray(R.array.list_image_story)
        val listStory: MutableList<Story> = mutableListOf()
        for (i in listName.indices) {
            val numberRate = Random().nextInt(5) + 1
//            val story =
//                Story(listImage[i],listName,numberRate,)
//            listStory.add(story)
        }
//        listStoryLiveData.postValue(storyList)


    }

}