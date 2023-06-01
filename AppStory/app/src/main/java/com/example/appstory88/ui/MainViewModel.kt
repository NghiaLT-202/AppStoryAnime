package com.example.appstory88.ui

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


    fun initData() {
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

            "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!", "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!", "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!", "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!", "Hãy bước vào thế giới kỳ diệu của giấy in nhiệt, nơi mà sự hài hước và sự tò mò gặp gỡ để tạo nên những trải nghiệm độc đáo. Có ai đó đã nghĩ ra ý tưởng tuyệt vời này: viết nội dung trên giấy, rồi chờ đợi một phép màu xảy ra.\n" +
                    "\n" +
                    "Chỉ cần áp dụng nhiệt độ, những gì đã viết trên giấy sẽ xuất hiện trước mắt bạn một cách thần kỳ. Đó là những lúc mà bạn như một nhà pháp sư đang triệu hồi sự sống vào giấy trắng, và ngay lập tức sự tò mò của bạn được kích thích.\n" +
                    "\n" +
                    "Không chỉ dừng lại ở việc in ấn thông thường, giấy in nhiệt còn mang đến cho bạn khả năng sáng tạo vô tận. Bạn có thể tạo ra trò chơi, câu đố hay những bức tranh độc đáo. Và dù bạn là người viết hay là người đọc, sự hài hước và tò mò luôn luôn theo kịp bạn.\n" +
                    "\n" +
                    "Hãy để giấy in nhiệt làm cho cuộc sống thêm màu sắc, mang đến những trải nghiệm bất ngờ và cười thả ga. Hãy đắm chìm trong thế giới của giấy in nhiệt, nơi sự hài hước, tò mò và sáng tạo gặp gỡ. Hãy để phép màu của giấy in nhiệt thổi bay đi những căng thẳng và mang đến niềm vui cho cuộc sống của bạn!"
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