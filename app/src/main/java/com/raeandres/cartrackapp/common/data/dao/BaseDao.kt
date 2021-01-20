package com.raeandres.cartrackapp.common.data.dao

import androidx.lifecycle.LiveData
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Login
import com.raeandres.cartrackapp.common.data.real.persistence.entity.User
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Country

interface BaseDao

interface BaseLoginDao : BaseDao {
    fun getUserLogin() : LiveData<Login>
}

interface BaseUserDao : BaseDao {
    fun getUserList(userName: String): LiveData<List<User>>
}

interface BaseCountryDao : BaseDao {
    fun getCountries() : LiveData<List<Country>>
}