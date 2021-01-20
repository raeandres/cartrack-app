package com.raeandres.cartrackapp.common.data.fake.persistence

import com.raeandres.cartrackapp.common.data.fake.persistence.dao.FakeLoginDao
import com.raeandres.cartrackapp.common.data.fake.persistence.dao.FakeUserDao


abstract class FakeAbstractDatabase(){

    abstract fun loginDao(): FakeLoginDao

    abstract fun getUserDao(): FakeUserDao
}

class FakeDatabase : FakeAbstractDatabase() {

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeDatabase()
        }
    }

    override fun loginDao(): FakeLoginDao {
       return FakeLoginDao
    }

    override fun getUserDao(): FakeUserDao {
        return FakeUserDao
    }

}


