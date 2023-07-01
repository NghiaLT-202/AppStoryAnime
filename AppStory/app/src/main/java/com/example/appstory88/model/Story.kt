package com.example.appstory88.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.appstory88.utils.Converters

@Entity
class Story(
    @ColumnInfo var imageStory: String,
    @ColumnInfo var nameStory: String,
    @ColumnInfo var numberStar: Int,
    @ColumnInfo var nameAuthor: String,
    @ColumnInfo
    @field:TypeConverters(Converters::class)
    var nameCategory: ArrayList<String>,
    @ColumnInfo var numberView: Long,
    @ColumnInfo var status: Boolean,
    @ColumnInfo var describe: String,
    @ColumnInfo var chapter: String,
    @ColumnInfo var chapterSum: Int,
    @ColumnInfo var checkBookmark: Boolean,
    @ColumnInfo var typeCategory: String
) {
    @PrimaryKey(autoGenerate = true)
    var idStory: Int = 0

}
