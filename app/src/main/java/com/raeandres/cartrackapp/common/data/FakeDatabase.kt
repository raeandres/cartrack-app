package com.raeandres.cartrackapp.common.data

class FakeDatabase private constructor(){

    var loginDao = FakeLoginDao()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeDatabase().also { instance = it }
        }
    }
}