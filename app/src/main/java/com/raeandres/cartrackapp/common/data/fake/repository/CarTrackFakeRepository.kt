package com.raeandres.cartrackapp.common.data.fake.repository

import com.raeandres.cartrackapp.common.data.fake.persistence.dao.FakeLoginDao

class CarTrackFakeRepository internal constructor(private val fakeLoginDao: FakeLoginDao){



    companion object {
        @Volatile private var instance: CarTrackFakeRepository? = null

        fun getInstance(loginDao : FakeLoginDao) = instance ?: synchronized(this) {
            instance ?: CarTrackFakeRepository(loginDao).also { instance = it }
        }
    }
}