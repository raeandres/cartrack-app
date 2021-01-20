package com.raeandres.cartrackapp.common.data.real.repository

import androidx.lifecycle.LiveData
import com.raeandres.cartrackapp.common.data.dao.BaseDao
import com.raeandres.cartrackapp.common.data.real.persistence.dao.LoginDao
import com.raeandres.cartrackapp.common.data.real.persistence.dao.UserDao
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Login
import com.raeandres.cartrackapp.common.data.real.persistence.entity.User

class CarTrackRepository internal constructor(private val loginDao: BaseDao, private val userDao: UserDao){

    val login : LiveData<Login> = loginDao.getUserLogin()

    fun userList(search: String): LiveData<List<User>> = userDao.getUserList(search)

    companion object {
        @Volatile private var instance: CarTrackRepository? = null

        fun getInstance(baseDao : BaseDao, userDao: UserDao) = instance ?: synchronized(this) {
            instance ?: CarTrackRepository(baseDao,userDao).also { instance = it }
        }
    }
}
