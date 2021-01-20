package com.raeandres.cartrackapp.common.data.fake.persistence.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raeandres.cartrackapp.common.data.dao.BaseCountryDao
import com.raeandres.cartrackapp.common.utilities.AndroidUtil
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Country


interface FakeCountryDao : BaseCountryDao {

    companion object : FakeCountryDao

    override fun getCountries(): LiveData<List<Country>> {
       val mutableLiveData  = MutableLiveData<List<Country>>()

        val jsonString = AndroidUtil.getJsonDataFromAsset("countries.json") ?: ""

        val jsonObject = Gson().fromJson<List<Country>>(jsonString,object : TypeToken<List<Country>>() {}.type)

        mutableLiveData.value = jsonObject
        return mutableLiveData
    }


}