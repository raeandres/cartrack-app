package com.raeandres.cartrackapp.feature.auth.login.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raeandres.cartrackapp.common.data.UserRepository

class LoginVmFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }
}