package com.raeandres.cartrackapp.common.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raeandres.cartrackapp.common.data.repository.CarTrackRepository

class UserViewModelFactory(private val repository: CarTrackRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return super.create(modelClass)
    }

}