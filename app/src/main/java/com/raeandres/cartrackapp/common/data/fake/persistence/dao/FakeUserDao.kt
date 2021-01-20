package com.raeandres.cartrackapp.common.data.fake.persistence.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raeandres.cartrackapp.common.data.dao.BaseUserDao
import com.raeandres.cartrackapp.common.data.real.persistence.entity.User

interface FakeUserDao : BaseUserDao {

    companion object : FakeUserDao

    override fun getUserList(userName: String): LiveData<List<User>> {
        val mutableLiveDataList = MutableLiveData<List<User>>()

        val dummy = User(
            website = "www.testwebsite.com",
            address = "123 Sesame st.",
            phone = "09123456789",
            name = "John Doe",
            company = "ABC Company",
            email = "john_doe@mail.com",
            username = "john_doe",
            id = 1
        )

        val userList = mutableListOf<User>()
        userList.add(dummy)
        userList.also {
            mutableLiveDataList.value = it
        }
        return mutableLiveDataList
    }
}