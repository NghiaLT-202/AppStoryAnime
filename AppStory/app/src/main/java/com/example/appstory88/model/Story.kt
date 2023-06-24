package com.example.appstory88.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Story(
    @ColumnInfo var imageStory: String,
    @ColumnInfo var nameStory: String,
    @ColumnInfo var numberStar: Int,
    @ColumnInfo var nameAuthur: String,
    @ColumnInfo var nameCategory: String,
    @ColumnInfo var numberView: Long,
    @ColumnInfo var status: Boolean,
    @ColumnInfo var describe: String,
    @ColumnInfo var chapter: String,
    @ColumnInfo var chapterSum: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var idStory: Int = 0

}
