package com.example.appstory88.ui

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.appstory88.R
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.data.dao.StoryDao
import com.example.appstory88.data.database.AppDatabase
import com.example.appstory88.data.model.ItemCategory
import com.example.appstory88.data.model.ItemTopStory
import com.example.appstory88.data.model.Story
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
    val listBookmarkStory = MutableLiveData<MutableList<Story>>()



    fun initDataTopStory(context: Context) {

        val listColor = context.resources.getStringArray(R.array.colorTopStory)
        val numberColor = Random().nextInt(listColor.size - 1) + 1

        val listTopStory: MutableList<ItemTopStory> = mutableListOf()
//        listTopStory.add(
//            ItemTopStory(
//                context.getString(R.string.truy_n_dc),
//                listColor[numberColor]
//            )
//        )
//        listTopStory.add(
//            ItemTopStory(
//                context.getString(R.string.truy_n_hot),
//                listColor[numberColor]
//            )
//        )
        val listCategory = context.resources.getStringArray(R.array.list_category_story)
        for (i in listCategory.indices) {
            val randomColor = Random().nextInt(listColor.size - 1) + 1
            listTopStory.add(
                ItemTopStory(
                    listCategory[i].split(",")[0].trim(),
                    listColor[randomColor]
                )
            )
        }
        listTopStory.filter {
            it.name == context.getString(R.string.truy_n_dc) || it.name == context.getString(
                R.string.truy_n_hot
            )
        }.toMutableList()



        listTopStoryLiveData.postValue(listTopStory)
    }


    fun initDataCategory(context: Context, allStory: MutableList<Story>) {
        val listColor = context.resources.getStringArray(R.array.colorTopStory)
        val listCategories: MutableList<ItemCategory> = mutableListOf()
        val listCategory = context.resources.getStringArray(R.array.list_category_story)
        for (i in listCategory.indices) {
            val randomColor = Random().nextInt(listColor.size - 1) + 1
            ItemCategory().apply {
                name = listCategory[i]
                color = listColor[randomColor]
                listStory = allStory.filter { it.typeCategory == name } as MutableList<Story>
                listCategories.add(this)
            }
        }
        listCategories.filter { it.listStory.size > 0 }.toMutableList()
        listCategories.sortByDescending { it.listStory.size }

        listCategoryLiveData.postValue(listCategories)
    }


    fun initlistCategoryData(list: MutableList<Story>, name: String) {
        listCategoryData.postValue(list.filter { it.nameStory == name }
            .toMutableList())
    }

    fun initListStoryNewUpdateLiveData(list: MutableList<Story>, nameCategory: String) {
        listStoryNewUpdateLiveData.postValue(list.filter { it.typeCategory == nameCategory }
            .toMutableList())
    }

    fun initListStoryFullAdapterLiveData(list: MutableList<Story>, nameCategory: String) {
        listStoryFullAdapterLiveData.postValue(list.filter { it.typeCategory == nameCategory }
            .toMutableList())
    }

    fun initListStoryGoodLoveLanguageLiveData(list: MutableList<Story>, nameCategory: String) {
        listStoryGoodLoveLanguageLiveData.postValue(list.filter {
            it.typeCategory == nameCategory
        }
            .toMutableList())
    }

    fun initListStoryGoodFairyTaleLiveData(list: MutableList<Story>, nameCategory: String) {
        listStoryGoodFairyTaleLiveData.postValue(list.filter {
            it.typeCategory == nameCategory
        }
            .toMutableList())
    }

    fun initListStoryGoodPassionLiveData(list: MutableList<Story>, nameCategory: String) {
        listStoryGoodPassionLiveData.postValue(list.filter {
            it.typeCategory == nameCategory
        }.toMutableList())
    }

    fun initListStoryLiveData(list: MutableList<Story>, type: String) {
        listStoryMoreLiveData.postValue(list.filter {
            it.nameCategory.contains(type)
        }.toMutableList())
    }

    fun initListDetailStoryLiveData(list: MutableList<Story>, type: String) {

        listStoryDetailLiveData.postValue(list.filter { it.nameCategory.contains(type) }
            .toMutableList())
    }


    fun initListRateStoryLiveData(list: MutableList<Story>) {
        list.sortWith(compareByDescending(Story::numberView))
        listStoryRateLiveData.postValue(list)
    }


    @SuppressLint("DiscouragedApi")
    fun initData(context: Context) {

        //Size name  =200
        val listName = context.resources.getStringArray(R.array.list_name_story)
        val listTypeCategory = context.resources.getStringArray(R.array.list_type_story)
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
            val numberType = Random().nextInt(listTypeCategory.size - 1) + 1
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
                    listCategory[numberCategory].split(",").map { it.trim() } as ArrayList<String>,
                    listnumberView[i].toLong(),
                    status,
                    listContent[0],
                    listChappter[i],
                    90,
                    listTypeCategory[numberType]
                )
            listStory.add(story)
        }
        listStoryLiveData.postValue(listStory)

    }


}