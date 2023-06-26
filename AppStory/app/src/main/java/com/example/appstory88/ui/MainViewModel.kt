package com.example.appstory88.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.appstory88.R
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.database.AppDatabase.Companion.appDatabase
import com.example.appstory88.model.ItemCategory
import com.example.appstory88.model.ItemTopStory

import com.example.appstory88.model.Story
import java.util.Random

class MainViewModel : BaseViewModel() {

    val listStoryLiveData = MutableLiveData<MutableList<Story>>()
    val listCategoryLiveData = MutableLiveData<MutableList<ItemCategory>>()
    val listStoryMoreLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryDetailLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryRateLiveData = MutableLiveData<MutableList<Story>>()
    val listCategoryData = MutableLiveData<MutableList<Story>>()

    val listStoryNewUpdateLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryFullAdapterLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryGoodLoveLanguageLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryGoodFairyTaleLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryGoodPassionLiveData = MutableLiveData<MutableList<Story>>()

    //list
    var listTopStoryLiveData: MutableLiveData<MutableList<ItemTopStory>> = MutableLiveData()

    fun initDataTopStory(context: Context) {
        val listColor = context.resources.getStringArray(R.array.colorTopStory)
        val numberColor = Random().nextInt(listColor.size - 1) + 1
        val listTopStory: MutableList<ItemTopStory> = mutableListOf()
        listTopStory.add(ItemTopStory(context.getString(R.string.truy_n_dc), listColor[numberColor]))
        listTopStory.add(ItemTopStory(context.getString(R.string.truy_n_hot), listColor[numberColor]))
        val listCategory = context.resources.getStringArray(R.array.list_category_story)
        for (i in listCategory.indices) {
            val randomColor = Random().nextInt(listColor.size - 1) + 1
            listTopStory.add(ItemTopStory(listCategory[i], listColor[randomColor]))
        }
        listTopStoryLiveData.postValue(listTopStory)
    }


    fun initDataCategory(context: Context, allStory: MutableList<Story>) {
        val listColor = context.resources.getStringArray(R.array.colorTopStory)
        val listCategories: MutableList<ItemCategory> = mutableListOf()
        val listCategory = context.resources.getStringArray(R.array.list_category_story)
        for (i in listCategory.indices) {
            val randomColor = Random().nextInt(listColor.size - 1) + 1
            val itemCategory = ItemCategory(
                listCategory[i], listColor[randomColor], getSizeCategory(
                    listCategory[i], allStory
                )
            )
            listCategories.add(itemCategory)
        }
        listCategories.sortByDescending { it.sumStory }
        listCategories.filter { it.sumStory > 0 }.toMutableList()
        listCategoryLiveData.postValue(listCategories)
    }

    private fun getSizeCategory(nameCategory: String, allStory: MutableList<Story>): Int {
        val lisStoryOfCate = allStory.filter { it.nameCategory == nameCategory }
        return lisStoryOfCate.size
    }



    fun initlistCategoryData(list: MutableList<Story>,name:String) {


        listCategoryData.postValue(list.filter { it.nameStory == name }
            .toMutableList())


    }
    fun initlistStoryNewUpdateLiveData(list: MutableList<Story>,nameCategory: String) {
        listStoryNewUpdateLiveData.postValue(list.filter { it.nameCategory == nameCategory }
            .toMutableList())
   }

    fun initlistStoryFullAdapterLiveData(list: MutableList<Story>,nameCategory: String) {
        listStoryFullAdapterLiveData.postValue(list.filter { it.nameCategory == nameCategory }
            .toMutableList())
    }

    fun initlistStoryGoodLoveLanguageLiveData(list: MutableList<Story>,nameCategory: String) {
        listStoryGoodLoveLanguageLiveData.postValue(list.filter {
            it.nameCategory == nameCategory
        }
            .toMutableList())
    }

    fun initlistStoryGoodFairyTaleLiveData(list: MutableList<Story>,nameCategory: String) {
        listStoryGoodFairyTaleLiveData.postValue(list.filter {
            it.nameCategory == nameCategory
        }
            .toMutableList())
    }

    fun initlistStoryGoodPassionLiveData(list: MutableList<Story>,nameCategory: String) {
        listStoryGoodPassionLiveData.postValue(list.filter {
            it.nameCategory == nameCategory
        }.toMutableList())
    }

    fun initlistStoryLiveData(list: MutableList<Story>, type: String) {
        listStoryMoreLiveData.postValue(list.filter {
            it.nameCategory == type
        }.toMutableList())
    }

    fun initlistDetailStoryLiveData(list: MutableList<Story>, type: String) {

        listStoryDetailLiveData.postValue(list.filter { it.nameCategory == type }.toMutableList())
    }


    fun initListRateStoryLiveData(list: MutableList<Story>) {
        list.sortWith(compareByDescending(Story::numberView))
        listStoryRateLiveData.postValue(list)
    }


    @SuppressLint("DiscouragedApi")
    fun initData(context: Context) {

        //Size name  =200
        val listName = context.resources.getStringArray(R.array.list_name_story)
        //size content = 1
        val listContent = context.resources.getStringArray(R.array.list_content_story)

        //size category = 20
        val listCategory = context.resources.getStringArray(R.array.list_category_story)

        //size author = 200
        val listAuthor = context.resources.getStringArray(R.array.list_name_authur_story)
        val listnumberView = context.resources.getStringArray(R.array.list_number_view_story)
        val listChappter = context.resources.getStringArray(R.array.list_number_chapter_story)


        val listPathImage: MutableList<String> = mutableListOf()
        context.assets.list("story")?.toMutableList()?.let { list ->
            list.forEach { listPathImage.add("file:///android_asset/story/$it") }
        }

        val listStory: MutableList<Story> = mutableListOf()
        for (i in listName.indices) {
            val numberRate = Random().nextInt(5) + 1
            val numberCategory = Random().nextInt(listCategory.size - 1) + 1
            val numberAuthor = Random().nextInt(listAuthor.size - 1) + 1
            val numberImage = Random().nextInt(listPathImage.size - 1) + 1
            val status = Random().nextBoolean()
            val story =
                Story(
                    listPathImage[numberImage],
                    listName[i],
                    numberRate,
                    listAuthor[numberAuthor],
                    listCategory[numberCategory],
                    listnumberView[i].toLong(),
                    status,
                    listContent[0],
                    listChappter[i],
                    90,
                    false,
                )
            listStory.add(story)
        }
        listStoryLiveData.postValue(listStory)
//        val storyDao = appDatabase?.storyDao()
//        storyDao?.insertListStory(listStory)


    }

}