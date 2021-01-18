package com.raeandres.cartrackapp.common.data

class UserRepository private constructor(private val fakeLoginDao: FakeLoginDao){

    fun getLoginCredentials() = fakeLoginDao.getLogin()

    companion object {
        @Volatile private var instance: UserRepository? = null

        fun getInstance(fakeLoginDao: FakeLoginDao) = instance ?: synchronized(this) {
            instance ?: UserRepository(fakeLoginDao).also { instance = it }
        }
    }
}
