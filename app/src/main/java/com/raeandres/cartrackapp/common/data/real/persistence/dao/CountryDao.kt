package com.raeandres.cartrackapp.common.data.real.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.raeandres.cartrackapp.common.data.dao.BaseCountryDao
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Country

@Dao
interface CountryDao : BaseCountryDao {

    @Query("SELECT * FROM table_country")
    override fun getCountries(): LiveData<List<Country>>
}