package com.raeandres.cartrackapp.common.data.fake.persistence.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raeandres.cartrackapp.common.data.dao.BaseLoginDao
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Login

interface FakeLoginDao : BaseLoginDao {

    companion object : FakeLoginDao

    override fun getUserLogin() : LiveData<Login> {
        val mutableLiveLogin = MutableLiveData<Login>()
        Login(
            "user123",
            "password").also {
            mutableLiveLogin.value = it
        }
        return mutableLiveLogin
    }
}

