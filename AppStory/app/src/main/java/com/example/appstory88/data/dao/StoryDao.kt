package com.example.appstory88.data.dao


import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appstory88.data.model.Story

@Dao
interface StoryDao {
    @Query("SELECT * FROM STORY")
    fun getAllBookmark(): MutableList<Story>

    @Insert
    fun insertListStory(listStory: MutableList<Story>)

    @Insert
    fun insertStory(story: Story)


    @Query("DELETE FROM story where nameStory=:name")
    fun deleteBookmarkWithName(name: String?)

    @Query("DELETE FROM story ")
    fun deleteAllListBookmark()

//    @Query("SELECT * FROM story where checkBookmark=:check")
//    fun getAllBookmark(check: Boolean): MutableList<Story>
}