package com.raeandres.cartrackapp.common.utilities

import com.raeandres.cartrackapp.common.android.CarTrackApp
import com.raeandres.cartrackapp.common.data.fake.persistence.FakeDatabase
import com.raeandres.cartrackapp.common.data.real.persistence.CarTrackDatabase
import com.raeandres.cartrackapp.common.data.repository.CarTrackRepository
import com.raeandres.cartrackapp.feature.auth.login.ui.LoginViewModelFactory
import com.raeandres.cartrackapp.feature.countries.ui.CountrySelectionViewModelFactory

object InjectorUtil {

    private val appInstance = CarTrackApp.instance
    private val carTrackDatabase = CarTrackDatabase.getDatabase(appInstance)
    private val fakeDatabase = FakeDatabase.getInstance()


    fun provideLogin(runType: RunType) : LoginViewModelFactory {
        return when (runType) {
            is RunType.RealData -> {
                val carTrackRepository = CarTrackRepository.getInstance(
                    carTrackDatabase.loginDao(),
                    carTrackDatabase.userDao(),
                    carTrackDatabase.countryDao())
                LoginViewModelFactory(appInstance,carTrackRepository)
            }
            is RunType.FakeData -> {
                val carTrackRepository = CarTrackRepository.getInstance(
                    fakeDatabase.loginDao(),
                    fakeDatabase.getUserDao(),
                    fakeDatabase.getCountryDao())
                LoginViewModelFactory(appInstance,carTrackRepository)
            }
        }
    }

    fun provideCountryList() : CountrySelectionViewModelFactory {
        val carTrackRepository = CarTrackRepository.getInstance(
            fakeDatabase.loginDao(),
            fakeDatabase.getUserDao(),
            fakeDatabase.getCountryDao()
        )
        return CountrySelectionViewModelFactory(appInstance,carTrackRepository)

    }

}

sealed class RunType {
    object RealData : RunType()
    object FakeData : RunType()
}
