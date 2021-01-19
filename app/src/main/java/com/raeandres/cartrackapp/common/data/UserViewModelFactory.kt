package com.raeandres.cartrackapp.common.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raeandres.cartrackapp.common.data.repository.UserRepository

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return super.create(modelClass)
    }

}