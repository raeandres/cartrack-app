package com.raeandres.cartrackapp.feature.countries.ui

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.raeandres.cartrackapp.common.android.BaseViewModel
import com.raeandres.cartrackapp.common.data.repository.CarTrackRepository
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Country

class CountrySelectionViewModel(application: Application, repository: CarTrackRepository) : BaseViewModel(application, repository) {

    fun populateCountryList(lifecycleOwner: AppCompatActivity, countries: (List<Country>) -> Unit){
        carTrackRepository.getCountryList().observe(lifecycleOwner, { countryList ->
            countries.invoke(countryList)
        })
    }
}