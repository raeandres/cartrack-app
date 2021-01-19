package com.raeandres.cartrackapp.common.data.repository

import androidx.lifecycle.LiveData
import com.raeandres.cartrackapp.common.data.persistence.UserDao
import com.raeandres.cartrackapp.common.data.persistence.entity.User

class UserRepository constructor(private val loginDao: UserDao){

    val userLogin: LiveData<User> = loginDao.getUserLogin()
}
