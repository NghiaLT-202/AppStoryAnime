package com.example.appstory88.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appstory88.model.User
import com.example.appstory88.dao.UserDao
import com.example.appstory88.model.Story

@Database(entities = [User::class,Story::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

}
