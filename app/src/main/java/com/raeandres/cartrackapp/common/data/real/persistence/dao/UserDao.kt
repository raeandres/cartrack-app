package com.raeandres.cartrackapp.common.data.real.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.raeandres.cartrackapp.common.data.dao.BaseUserDao
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Login
import com.raeandres.cartrackapp.common.data.real.persistence.entity.User

@Dao
interface UserDao : BaseUserDao {

    @Query("SELECT * FROM user_table WHERE user_name LIKE :userName ORDER BY user_name asc")
    override fun getUserList(userName: String): LiveData<List<User>>

}