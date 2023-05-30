package com.example.appstory88.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.appstory88.model.Story

interface StoryDao {
    @Query("SELECT * FROM User")
    fun getAllStorys(): List<Story>
    @Insert
    fun insertStory(story: Story)
}