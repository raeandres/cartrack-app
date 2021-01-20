package com.raeandres.cartrackapp.common.android

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.raeandres.cartrackapp.common.data.real.persistence.CarTrackDatabase
import com.raeandres.cartrackapp.common.data.repository.CarTrackRepository

open class BaseViewModel(application: Application, val carTrackRepository: CarTrackRepository): AndroidViewModel(application) {

    protected val carTrackDb = CarTrackDatabase.getDatabase(application.applicationContext)


}