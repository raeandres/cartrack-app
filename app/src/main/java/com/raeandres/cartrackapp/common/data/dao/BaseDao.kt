package com.raeandres.cartrackapp.common.data.dao

import androidx.lifecycle.LiveData
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Login
import com.raeandres.cartrackapp.common.data.real.persistence.entity.User

interface BaseDao

interface BaseLoginDao : BaseDao {
    fun getUserLogin() : LiveData<Login>
}

interface BaseUserDao : BaseDao {
    fun getUserList(userName: String): LiveData<List<User>>
}