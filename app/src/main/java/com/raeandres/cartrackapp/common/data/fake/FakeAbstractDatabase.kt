package com.raeandres.cartrackapp.common.data.fake

import com.raeandres.cartrackapp.common.data.fake.persistence.dao.FakeLoginDao


abstract class FakeAbstractDatabase(){

    abstract fun loginDao(): FakeLoginDao


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

}


