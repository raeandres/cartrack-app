package com.raeandres.cartrackapp.common.data.repository

import androidx.lifecycle.LiveData
import com.raeandres.cartrackapp.common.data.dao.BaseLoginDao
import com.raeandres.cartrackapp.common.data.dao.BaseUserDao
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Login
import com.raeandres.cartrackapp.common.data.real.persistence.entity.User

class CarTrackRepository internal constructor(private val baseLoginDao: BaseLoginDao, private val userDao: BaseUserDao){

    val login : LiveData<Login> = baseLoginDao.getUserLogin()

    fun userList(search: String): LiveData<List<User>> = userDao.getUserList(search)

    companion object {
        @Volatile private var instance: CarTrackRepository? = null

        fun getInstance(baseLoginDao : BaseLoginDao, baseUserDao: BaseUserDao) = instance ?: synchronized(this) {
            instance ?: CarTrackRepository(baseLoginDao,baseUserDao).also { instance = it }
        }
    }
}
