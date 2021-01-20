package com.raeandres.cartrackapp.common.data.real.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raeandres.cartrackapp.common.data.dao.BaseDao
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Login

@Dao
interface LoginDao : BaseDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(login: Login)

    @Query("SELECT * FROM table_login ORDER BY user_name ASC")
    override fun getUserLogin(): LiveData<Login>
}