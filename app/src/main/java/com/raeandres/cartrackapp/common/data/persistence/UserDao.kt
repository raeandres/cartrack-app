package com.raeandres.cartrackapp.common.data.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raeandres.cartrackapp.common.data.persistence.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM table_login ORDER BY user_name ASC")
    fun getUserLogin(): LiveData<User>
}