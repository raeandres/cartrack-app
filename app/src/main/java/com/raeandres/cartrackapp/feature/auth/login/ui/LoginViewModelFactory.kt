package com.raeandres.cartrackapp.feature.auth.login.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raeandres.cartrackapp.common.data.real.repository.CarTrackRepository

class LoginViewModelFactory( private val application: Application,private val repository: CarTrackRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(application, repository) as T
    }
}