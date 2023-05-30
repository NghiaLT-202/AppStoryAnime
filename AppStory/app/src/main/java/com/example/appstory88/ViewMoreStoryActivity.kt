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
            listStory.shuffle()

            setListStory(listStory)
        }
    }
}