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
            context.getString(R.string.ti_u_ng_o_giang_h_l_t_qua_s_ng),
            context.getString(R.string.quan_v_n_tr_ng),
            context.getString(R.string.ho_ng_h_u_th_i_y_ti_n_truy_n),
            context.getString(R.string.m_t_ki_m_phong_s_ng),
            context.getString(R.string.th_gi_i_anh_v_em),
        )
        val listNumberStar = intArrayOf(
            2,
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
            context.getString(R.string.tu_n_d_ng),
        )
        val listNameCategory = arrayOf(
            context.getString(R.string.truy_n_m_i),
            context.getString(R.string.truy_n_full),
            context.getString(R.string.ng_n_t_nh),
            context.getString(R.string.ti_n_hi_p),
            context.getString(R.string.am_m),
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
            context.getString(R.string.ch_ng_1),
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
            9,
        )
        for (i in listNameStory.indices) {
            val story = Story(listImage[i],listNameStory[i],listNumberStar[i],listNameAuthur[i],listNameCategory[i],listView[i],listStatus[i],listDescibe[i],listChapter[i],listChapterSum[i])
            storyList.add(story)
        }
        listStoryLiveData.postValue(storyList)


    }
}