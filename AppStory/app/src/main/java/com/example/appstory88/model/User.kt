package com.example.appstory88.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(

    @ColumnInfo var name: String
    // Thêm các thuộc tính khác
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
