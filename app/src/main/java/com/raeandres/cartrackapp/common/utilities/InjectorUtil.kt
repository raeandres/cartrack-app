package com.raeandres.cartrackapp.common.utilities

import com.raeandres.cartrackapp.common.android.CarTrackApp
import com.raeandres.cartrackapp.common.data.fake.persistence.FakeDatabase
import com.raeandres.cartrackapp.common.data.real.persistence.CarTrackDatabase
import com.raeandres.cartrackapp.common.data.repository.CarTrackRepository
import com.raeandres.cartrackapp.feature.auth.login.ui.LoginViewModelFactory

object InjectorUtil {

    fun provideLogin(runType: RunType) : LoginViewModelFactory {
        val appInstance = CarTrackApp.instance
        val carTrackDatabase = CarTrackDatabase.getDatabase(appInstance)

        return when (runType) {
            is RunType.RealData -> {
                val carTrackRepository = CarTrackRepository.getInstance(carTrackDatabase.loginDao(),carTrackDatabase.userDao())
                LoginViewModelFactory(appInstance,carTrackRepository)
            }
            is RunType.FakeData -> {
                val fakeDatabase = FakeDatabase.getInstance()
                val carTrackRepository = CarTrackRepository.getInstance(fakeDatabase.loginDao(), fakeDatabase.getUserDao())
                LoginViewModelFactory(appInstance,carTrackRepository)
            }
        }
    }

}

sealed class RunType {
    object RealData : RunType()
    object FakeData : RunType()
}
