package com.example.appstory88.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appstory88.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>
    @Insert
    fun insertUser(user: User)
    // Thêm các phương thức khác cho các truy vấn và thao tác khác

}
