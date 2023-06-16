package com.example.appstory88.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Story(
    var imageStory: Int,
    var nameStory: String,
    var numberStar: Int,
    var nameAuthur: String,
    var nameCategory: String,
    var numberView: Long,
    var status: Boolean,
    var describe: String,
    var chapter: String,
    var chapterSum: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var idStory: Int = 0

}
