package com.raeandres.cartrackapp.common.data.dao

import androidx.lifecycle.LiveData
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Login

interface BaseDao {
    fun getUserLogin() : LiveData<Login>
}