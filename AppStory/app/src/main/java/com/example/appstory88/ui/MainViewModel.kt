package com.example.appstory88.ui

import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import com.example.appstory88.R
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.model.Story

class MainViewModel : BaseViewModel() {
    var listStoryLiveData = MutableLiveData<MutableList<Story>>()


    override fun onCleared() {
        super.onCleared()
    }


    fun initData(context: Context) {
        val storyList: MutableList<Story> = mutableListOf()
        val listImage = intArrayOf(
            R.drawable.anime5,
            R.drawable.anime4,
            R.drawable.anime3,
            R.drawable.anime2,
            R.drawable.anime1,
        )
        val listNameStory = arrayOf(
            "Tiếu ngạo giang hồ lồ tồ qua sông",
            "Quan vân trường",
            "Hoàng hậu thái y tiền truyện",
            "Một kiếm phong sương",
            "Thế giới anh và em",
        )
        val listNumberStar = intArrayOf(
            2,
            3,
            4,
            5,
            1,
        )
        val listNameAuthur = arrayOf(
            "Tuấn Nghĩa",
            "Tuấn Linh",
            "Tuấn Sơn",
            "Tuấn Hồng",
            "Tuấn Dũng",
        )
        val listNameCategory = arrayOf(
            "Kiếm hiệp",
            "Tình cảm",
            "Đam mỹ",
            "Học sinh",
            "Cổ tích",
        )
        val listView = longArrayOf(
            1000000,
            100060,
            6099500,
            88500,
            360660,
        )
        val listStatus = arrayOf(
            true,
            false,
            true,
            true,
            false,
        )
        val listDescibe = arrayOf(
            context.getString( R.string.describe_story),
            context.getString( R.string.describe_story),
            context.getString( R.string.describe_story),
            context.getString( R.string.describe_story),
            context.getString( R.string.describe_story),

        )
        val listChapter= arrayOf(
            "Chương 1",
            "Chương 2",
            "Chương 3",
            "Chương 4",
            "Chương 5",
        )
        val listChapterSum = arrayOf(
            20,
            35,
            45,
            36,
            9,
        )
        for (i in listNameStory.indices) {
            val story = Story(listImage[i],listNameStory[i],listNumberStar[i],listNameAuthur[i],listNameCategory[i],listView[i],listStatus[i],listDescibe[i],listChapter[i],listChapterSum[i])
            storyList.add(story)
        }
        listStoryLiveData.postValue(storyList)


    }
}