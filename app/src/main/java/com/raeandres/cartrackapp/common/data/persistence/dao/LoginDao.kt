package com.raeandres.cartrackapp.common.data.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raeandres.cartrackapp.common.data.persistence.entity.Login

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(login: Login)

    @Query("SELECT * FROM table_login ORDER BY user_name ASC")
    fun getUserLogin(): LiveData<Login>
}