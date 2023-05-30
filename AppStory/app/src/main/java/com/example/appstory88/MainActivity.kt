package com.example.appstory88

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.appstory88.adapter.StoryAdapter
import com.example.appstory88.adapter.StoryBanerAdapter
import com.example.appstory88.database.AppDatabase
import com.example.appstory88.databinding.HomeActivityBinding
import com.example.appstory88.model.Story
import com.example.appstory88.model.User
import com.example.appstory88.ui.describestory.ViewDescribeStoryFragment
import com.example.appstory88.ui.morestory.ViewMoreStoryActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: HomeActivityBinding
    private val listStory: ArrayList<Story> = ArrayList<Story>()
    var storyAdapter: StoryAdapter? = null
    var storyBannerAdapter: StoryBanerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_activity)

        val appDatabase = Room.databaseBuilder(
            this, AppDatabase::class.java, "app-database"
        ).allowMainThreadQueries().build()
        val userDao = appDatabase.userDao()
        val newUser = User("John Doe")
        userDao.insertUser(newUser)
        initAdapter()
        initListener()
    }

    private fun initListener() {

        binding.imViewMoreStoryFull.setOnClickListener {
            var intent = Intent(this, ViewMoreStoryActivity::class.java)

            startActivity(intent)
        }
        binding.imViewMoreGoodPassion.setOnClickListener {
            var intent = Intent(this, ViewMoreStoryActivity::class.java)

            startActivity(intent)
        }
        binding.imViewMoreGoodFairyTale.setOnClickListener {
            var intent = Intent(this, ViewMoreStoryActivity::class.java)

            startActivity(intent)
        }
        binding.imViewMoreGoodLoveLanguage.setOnClickListener {
            var intent = Intent(this, ViewMoreStoryActivity::class.java)
            Log.e("tnghia", "hhh")
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
            initData()
            listStory.shuffle()
            setListStoryBanner(listStory)
        }
        storyBannerAdapter?.iclick = object : StoryBanerAdapter.Iclick {
            override fun clickItem(position: Int) {
                val intent = Intent(this@MainActivity, ViewDescribeStoryFragment::class.java)
                val bundle = Bundle()
                bundle.putString("key", "value")
                var name = listStory[position].nameStory
                var numberStar = listStory[position].numberStar
                var view = listStory[position].numberView
                var authur = listStory[position].nameAuthur
                var category = listStory[position].nameCategory
                var describe = listStory[position].describe
                intent.putExtra("", bundle)
                startActivity(intent)
            }


        }
        storyAdapter = StoryAdapter().apply {
            binding.rcItemStory.adapter = this
            listStory.shuffle()
            setListStory(listStory)
        }
        storyAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, ViewDescribeStoryFragment::class.java)
                startActivity(intent)
            }

        }


        storyAdapter = StoryAdapter().apply {
            binding.rcItemStoryFull.adapter = this
            listStory.reverse()
            setListStory(listStory)
        }
        storyAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                var intent = Intent(this@MainActivity, ViewDescribeStoryFragment::class.java)
                startActivity(intent)
            }

        }
        storyAdapter = StoryAdapter().apply {
            binding.rcItemGoodLoveLanguage.adapter = this
            listStory.shuffle()
            setListStory(listStory)
        }
        storyAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                var intent = Intent(this@MainActivity, ViewDescribeStoryFragment::class.java)
                startActivity(intent)
            }

        }
        storyAdapter = StoryAdapter().apply {
            binding.rcItemGoodFairyTale.adapter = this
            listStory.reverse()
            listStory.shuffle()
            setListStory(listStory)
        }
        storyAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                var intent = Intent(this@MainActivity, ViewDescribeStoryFragment::class.java)
                startActivity(intent)
            }

        }
        storyAdapter = StoryAdapter().apply {
            binding.rcItemGoodPassion.adapter = this
            listStory.shuffle()
            setListStory(listStory)
        }
        storyAdapter?.onItemClickListener = object : StoryAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                var intent = Intent(this@MainActivity, ViewDescribeStoryFragment::class.java)
                startActivity(intent)
            }

        }


    }


    private fun initData() {
        val story = Story(0,
            R.drawable.anime5,
            "Tiếu ngạo giang hồ lồ tồ qua sông",
            2,
            "Tuấn Nghĩa",
            "Kiếm hiệp",
            1000,
            true,
            "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!"
        )
        story.nameAuthur = ""
        val story1 = Story(1,
            R.drawable.anime4,
            "Tiếu ngạo giang hồ lồ tồ qua sông",
            0,
            "Tuấn Nghĩa",
            "Kiếm hiệp",
            1000,
            true,
            "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!"
        )
        val story2 = Story(2,
            R.drawable.anime3,
            "Tiếu ngạo giang hồ lồ tồ qua sông",
            4,
            "Tuấn Nghĩa",
            "Kiếm hiệp",
            1000,
            true,
            "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!"
        )
        val story3 = Story(3,
            R.drawable.anime2,
            "Tiếu ngạo giang hồ lồ tồ qua sông",
            5,
            "Tuấn Nghĩa",
            "Kiếm hiệp",
            1000,
            true,
            "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!"
        )
        val story4 = Story(4,
            R.drawable.anime1,
            "Tiếu ngạo giang hồ lồ tồ qua sông",
            2,
            "Tuấn Nghĩa",
            "Kiếm hiệp",
            1000,
            true,
            "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!"
        )
        val story5 = Story(5,
            R.drawable.anime5,
            "Tiếu ngạo giang hồ lồ tồ qua sông",
            3,
            "Tuấn Nghĩa",
            "Kiếm hiệp",
            1000,
            true,
            "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!"
        )
        val story6 = Story(6,
            R.drawable.anime4,
            "Tiếu ngạo giang hồ lồ tồ qua sông",
            1,
            "Tuấn Nghĩa",
            "Kiếm hiệp",
            1000,
            true,
            "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!"
        )
        listStory.add(story)
        listStory.add(story1)
        listStory.add(story2)
        listStory.add(story3)
        listStory.add(story4)
        listStory.add(story5)
        listStory.add(story6)
    }


}