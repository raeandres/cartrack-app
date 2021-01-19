package com.raeandres.cartrackapp.common.data.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.raeandres.cartrackapp.common.data.persistence.entity.Login
import com.raeandres.cartrackapp.common.data.persistence.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE user_name LIKE :userName ORDER BY user_name asc")
    fun getUserList(userName: String): LiveData<List<User>>

}