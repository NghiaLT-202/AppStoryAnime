package com.example.appstory88

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.databinding.LayoutViewListMoreStoryBinding
import com.example.appstory88.model.Story

class ViewMoreStoryActivity : AppCompatActivity() {
    lateinit var binding: LayoutViewListMoreStoryBinding
    var storyAdapter: StoryAdapter? = null
    private val listStory: ArrayList<Story> = ArrayList<Story>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.layout_view_list_more_story)
        initAdapter()

    }

    private fun initAdapter() {

        storyAdapter = StoryAdapter().apply {
            binding.rcListStory.adapter = this
            val story = Story(
                R.drawable.anime5,
                "Tiếu ngạo giang hồ lồ tồ qua sông",
                2,
                "Tuấn Nghĩa",
                "Kiếm hiệp"
            )
            val story1 = Story(
                R.drawable.anime4,
                "Tiếu ngạo giang hồ lồ tồ qua sông",
                0,
                "Tuấn Nghĩa",
                "Kiếm hiệp"
            )
            val story2 = Story(
                R.drawable.anime3,
                "Tiếu ngạo giang hồ lồ tồ qua sông",
                4,
                "Tuấn Nghĩa",
                "Kiếm hiệp"
            )
            val story3 = Story(
                R.drawable.anime2,
                "Tiếu ngạo giang hồ lồ tồ qua sông",
                5,
                "Tuấn Nghĩa",
                "Kiếm hiệp"
            )
            val story4 = Story(
                R.drawable.anime1,
                "Tiếu ngạo giang hồ lồ tồ qua sông",
                2,
                "Tuấn Nghĩa",
                "Kiếm hiệp"
            )
            val story5 = Story(
                R.drawable.anime5,
                "Tiếu ngạo giang hồ lồ tồ qua sông",
                3,
                "Tuấn Nghĩa",
                "Kiếm hiệp"
            )
            val story6 = Story(
                R.drawable.anime4,
                "Tiếu ngạo giang hồ lồ tồ qua sông",
                1,
                "Tuấn Nghĩa",
                "Kiếm hiệp"
            )
            listStory.add(story)
            listStory.add(story1)
            listStory.add(story2)
            listStory.add(story3)
            listStory.add(story4)
            listStory.add(story5)
            listStory.add(story6)
            listStory.shuffle()

            setListStory(listStory)
        }
    }
}