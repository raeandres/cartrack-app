package com.raeandres.cartrackapp.common.android

import android.app.Application

class CarTrackApp: Application() {


    companion object {

        var instance = CarTrackApp()
//        @Volatile
//        private var instance : CarTrackApp? = null
//
//        fun getInstance() =
//            instance?: synchronized(this ) {
//            instance ?: CarTrackApp().also { instance = it }
//        }

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}