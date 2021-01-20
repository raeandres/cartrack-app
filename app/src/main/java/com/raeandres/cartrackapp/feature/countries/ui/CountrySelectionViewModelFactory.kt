package com.raeandres.cartrackapp.feature.countries.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raeandres.cartrackapp.common.data.repository.CarTrackRepository

class CountrySelectionViewModelFactory(private val application: Application, private val repository: CarTrackRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountrySelectionViewModel(application,repository) as T
    }
}