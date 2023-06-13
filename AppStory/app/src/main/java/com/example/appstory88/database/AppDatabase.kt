package com.example.appstory88.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appstory88.dao.StoryDao
import com.example.appstory88.model.Story

//@Database(entities = [Story::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun storyDao(): StoryDao

//    companion object {
//        var appDatabase: AppDatabase? = null
//        const val NAME_DATABASE = "appDataBase"
//        fun getInstanceDataBase(context: Context): AppDatabase {
//            if (appDatabase == null) {
//                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, NAME_DATABASE)
//                    .allowMainThreadQueries().build()
//            }
//            return appDatabase as AppDatabase
//
//        }
//    }


}
