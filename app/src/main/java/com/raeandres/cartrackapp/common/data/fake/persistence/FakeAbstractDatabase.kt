package com.raeandres.cartrackapp.common.data.fake.persistence

import android.app.Application
import com.raeandres.cartrackapp.common.data.fake.persistence.dao.FakeCountryDao
import com.raeandres.cartrackapp.common.data.fake.persistence.dao.FakeLoginDao
import com.raeandres.cartrackapp.common.data.fake.persistence.dao.FakeUserDao
import com.raeandres.cartrackapp.common.utilities.AndroidUtil


abstract class FakeAbstractDatabase(){

    abstract fun loginDao(): FakeLoginDao

    abstract fun getUserDao(): FakeUserDao

    abstract fun getCountryDao() : FakeCountryDao
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

    override fun getCountryDao(): FakeCountryDao {
        return FakeCountryDao
    }

}


