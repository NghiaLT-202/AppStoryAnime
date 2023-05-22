package com.example.appstory88

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.adapter.StoryBanerAdapter
import com.example.appstory88.databinding.HomeActivityBinding
import com.example.appstory88.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var binding: HomeActivityBinding
    private val listStory: ArrayList<Story> = ArrayList<Story>()
    var storyAdapter: StoryAdapter? = null
    var storyBannerAdapter: StoryBanerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_activity)
        initAdapter()
        initListener()
    }

    private fun initListener() {

        binding.imViewMoreStoryFull.setOnClickListener {
            var intent = Intent(this, ViewMoreStoryActivity::class.java)

            startActivity(intent)
        }
        binding.imViewMoreGoodPassion.setOnClickListener {
            var intent = Intent(this, ViewDescribeStory::class.java)

            startActivity(intent)
        }
        binding.imViewMoreGoodFairyTale.setOnClickListener {
            var intent = Intent(this, ViewMoreStoryActivity::class.java)

            startActivity(intent)
        }
        binding.imViewMoreGoodLoveLanguage.setOnClickListener {
            var intent = Intent(this, ViewMoreStoryActivity::class.java)

            startActivity(intent)
        }
        binding.imViewMoreNewStoryUpdated.setOnClickListener {
            var intent = Intent(this, ViewMoreStoryActivity::class.java)

            startActivity(intent)
        }
    }

    private fun initAdapter() {
        storyBannerAdapter = StoryBanerAdapter().apply {
            binding.rcItemStoryBanner.adapter = this
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

            setListStoryBanner(listStory)
        }
        storyAdapter = StoryAdapter().apply {
            binding.rcItemStory.adapter = this
            listStory.shuffle()


            setListStory(listStory)
        }
        storyAdapter = StoryAdapter().apply {
            binding.rcItemStoryFull.adapter = this
            listStory.reverse()
            setListStory(listStory)
        }
        storyAdapter = StoryAdapter().apply {
            binding.rcItemGoodLoveLanguage.adapter = this
            listStory.shuffle()

            setListStory(listStory)
        }
        storyAdapter = StoryAdapter().apply {
            binding.rcItemGoodFairyTale.adapter = this
            listStory.reverse()
            listStory.shuffle()


            setListStory(listStory)
        }
        storyAdapter = StoryAdapter().apply {
            binding.rcItemGoodPassion.adapter = this



            val itemCountLimit = 10 // Số lượng mục giới hạn bạn muốn hiển thị

            listStory.shuffle()


            setListStory(listStory)
        }


    }


}