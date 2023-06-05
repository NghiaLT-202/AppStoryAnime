package com.example.appstory88.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.appstory88.R
import com.example.appstory88.base.BaseViewModel
import com.example.appstory88.model.Story
import java.util.Random

class MainViewModel : BaseViewModel() {
    val TYPE_NEW_STORY="New story updated"
    val TYPE_FULL_STORY="Story full"
    val TYPE_GOOD_LOVE_STORY="Good love language"
    val TYPE_FAIRY_TALE_STORY="Good fairy tale"
    val TYPE_GOOD_PASSION_STORY="Good passion"
    val listStoryLiveData = MutableLiveData<MutableList<Story>>()
    val listStoryMoreLiveData = MutableLiveData<MutableList<Story>>()
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
        listStoryFullAdapterLiveData.postValue(list.filter {  it.nameCategory == TYPE_FULL_STORY}
            .toMutableList())
    }

    fun initlistStoryGoodLoveLanguageLiveData(list: MutableList<Story> ) {
        listStoryGoodLoveLanguageLiveData.postValue(list.filter {
            it.nameCategory == TYPE_GOOD_LOVE_STORY
        }
            .toMutableList())
    }

    fun initlistStoryGoodFairyTaleLiveData(list: MutableList<Story> ) {
        listStoryGoodFairyTaleLiveData.postValue(list.filter {
            it.nameCategory == TYPE_FAIRY_TALE_STORY
        }
            .toMutableList())
    }

    fun initlistStoryGoodPassionLiveData(list: MutableList<Story> ) {
        listStoryGoodPassionLiveData.postValue(list.filter {             it.nameCategory == TYPE_GOOD_PASSION_STORY
        }.toMutableList())
    }
    fun initlistStoryLiveData(list: MutableList<Story>, type:String) {
        listStoryMoreLiveData.postValue(list.filter {             it.nameCategory == type
        }.toMutableList())
    }
    fun initListRateStoryLiveData(list: MutableList<Story>) {
        list.sortWith(compareByDescending(Story::numberView))
        listStoryRateLiveData.postValue(list)
    }

    fun initData(context: Context) {
        val storyList: MutableList<Story> = mutableListOf()
        val listImage = intArrayOf(
            R.drawable.anime5,
            R.drawable.anime3,
            R.drawable.anime4,
            R.drawable.anime2,
            R.drawable.anime1,

            R.drawable.anime3,
            R.drawable.anime5,
            R.drawable.anime1,
            R.drawable.anime2,
            R.drawable.anime4,

            R.drawable.anime1,
            R.drawable.anime2,
            R.drawable.anime5,
            R.drawable.anime3,
            R.drawable.anime4,R.drawable.anime1,
            R.drawable.anime2,
            R.drawable.anime5,
            R.drawable.anime3,
            R.drawable.anime4,

        )
        val listNameStory = arrayOf(
            context.getString(R.string.ti_u_ng_o_giang_h_l_t_qua_s_ng),
            context.getString(R.string.quan_v_n_tr_ng),
            context.getString(R.string.ho_ng_h_u_th_i_y_ti_n_truy_n),
            context.getString(R.string.m_t_ki_m_phong_s_ng),
            context.getString(R.string.th_gi_i_anh_v_em),
            context.getString(R.string.ho_ng_h_u_th_i_y_ti_n_truy_n),

            context.getString(R.string.ti_u_ng_o_giang_h_l_t_qua_s_ng),
            context.getString(R.string.quan_v_n_tr_ng),
            context.getString(R.string.th_gi_i_anh_v_em),
            context.getString(R.string.m_t_ki_m_phong_s_ng),

            context.getString(R.string.quan_v_n_tr_ng),
            context.getString(R.string.m_t_ki_m_phong_s_ng),
            context.getString(R.string.th_gi_i_anh_v_em),

            context.getString(R.string.ho_ng_h_u_th_i_y_ti_n_truy_n),
            context.getString(R.string.ti_u_ng_o_giang_h_l_t_qua_s_ng),context.getString(R.string.quan_v_n_tr_ng),
            context.getString(R.string.m_t_ki_m_phong_s_ng),
            context.getString(R.string.th_gi_i_anh_v_em),

            context.getString(R.string.ho_ng_h_u_th_i_y_ti_n_truy_n),
            context.getString(R.string.ti_u_ng_o_giang_h_l_t_qua_s_ng),

        )
        val listNumberStar = intArrayOf(
            2,
            3,
            4,
            5,
            1, 2,
            3,
            4,
            5,
            1, 2,
            3,
            4,
            5,
            1,2,
            3,
            4,
            5,
            1,
        )
        val listNameAuthur = arrayOf(
            context.getString(R.string.tu_n_ngh_a),
            context.getString(R.string.tu_n_linh),
            context.getString(R.string.tu_n_s_n),
            context.getString(R.string.tu_n_h_ng),
            context.getString(R.string.tu_n_d_ng), context.getString(R.string.tu_n_ngh_a),
            context.getString(R.string.tu_n_linh),
            context.getString(R.string.tu_n_s_n),
            context.getString(R.string.tu_n_h_ng),
            context.getString(R.string.tu_n_d_ng), context.getString(R.string.tu_n_ngh_a),
            context.getString(R.string.tu_n_linh),
            context.getString(R.string.tu_n_s_n),
            context.getString(R.string.tu_n_h_ng),
            context.getString(R.string.tu_n_d_ng),context.getString(R.string.tu_n_ngh_a),
            context.getString(R.string.tu_n_linh),
            context.getString(R.string.tu_n_s_n),
            context.getString(R.string.tu_n_h_ng),
            context.getString(R.string.tu_n_d_ng),
        )
        val listNameCategory = arrayOf(
            context.getString(R.string.new_story_updated),
            context.getString(R.string.story_full),
            context.getString(R.string.good_love_language),
            context.getString(R.string.good_fairy_tale),
            context.getString(R.string.good_passion),

            context.getString(R.string.story_full),
            context.getString(R.string.new_story_updated),
            context.getString(R.string.good_passion),
            context.getString(R.string.good_love_language),
            context.getString(R.string.good_fairy_tale),

            context.getString(R.string.good_love_language),
            context.getString(R.string.new_story_updated),

            context.getString(R.string.good_fairy_tale),
            context.getString(R.string.good_passion),
            context.getString(R.string.story_full),

            context.getString(R.string.good_love_language),
            context.getString(R.string.good_passion),

            context.getString(R.string.story_full),
            context.getString(R.string.good_fairy_tale),
            context.getString(R.string.new_story_updated),




            )
        val listView = longArrayOf(
            1000000,
            100060,
            6099500,
            88500,
            360660, 1000000,
            100060,
            6099500,
            88500,
            360660, 1000000,
            100060,
            6099500,
            88500,
            360660,1000000,
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
            false, true,
            false,
            true,
            true,
            false, true,
            false,
            true,
            true,
            false, true,
            false,
            true,
            true,
            false,
        )
        val listDescibe = arrayOf(
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story), context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),
            context.getString(R.string.describe_story),

            )
        val listChapter = arrayOf(
            context.getString(R.string.ch_ng_1),
            context.getString(R.string.ch_ng_2),
            context.getString(R.string.ch_ng_3),
            context.getString(R.string.ch_ng_4),
            context.getString(R.string.ch_ng_5), context.getString(R.string.ch_ng_1),
            context.getString(R.string.ch_ng_2),
            context.getString(R.string.ch_ng_3),
            context.getString(R.string.ch_ng_4),
            context.getString(R.string.ch_ng_5), context.getString(R.string.ch_ng_1),
            context.getString(R.string.ch_ng_2),
            context.getString(R.string.ch_ng_3),
            context.getString(R.string.ch_ng_4),
            context.getString(R.string.ch_ng_5),context.getString(R.string.ch_ng_1),
            context.getString(R.string.ch_ng_2),
            context.getString(R.string.ch_ng_3),
            context.getString(R.string.ch_ng_4),
            context.getString(R.string.ch_ng_5),
        )
        val listChapterSum = arrayOf(
            20,
            35,
            45,
            36,
            9, 20,
            35,
            45,
            36,
            9, 20,
            35,
            45,
            36,
            9,20,
            35,
            45,
            36,
            9,
        )



        for (i in listNameStory.indices) {
            val story = Story(
                listImage[i],
                listNameStory[i],
                listNumberStar[i],
                listNameAuthur[i],
                listNameCategory[i],
                listView[i],
                listStatus[i],
                listDescibe[i],
                listChapter[i],
                listChapterSum[i]

            )
            storyList.add(story)
        }
        listStoryLiveData.postValue(storyList)


    }
}