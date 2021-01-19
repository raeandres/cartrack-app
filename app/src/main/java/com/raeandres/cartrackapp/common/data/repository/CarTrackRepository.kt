package com.raeandres.cartrackapp.common.data.repository

import androidx.lifecycle.LiveData
import com.raeandres.cartrackapp.common.data.persistence.dao.LoginDao
import com.raeandres.cartrackapp.common.data.persistence.dao.UserDao
import com.raeandres.cartrackapp.common.data.persistence.entity.Login
import com.raeandres.cartrackapp.common.data.persistence.entity.User

class CarTrackRepository (private val loginDao: LoginDao){

    val login: LiveData<Login> = loginDao.getUserLogin()

    fun userList(search: String, userDao: UserDao): LiveData<List<User>> = userDao.getUserList(search)
    
}
