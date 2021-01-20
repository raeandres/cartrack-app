package com.raeandres.cartrackapp.common.network

import com.google.gson.GsonBuilder
import com.raeandres.cartrackapp.common.utilities.JSON_PLACEHOLDER_ENDPOINT
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/** Rae-An Andres created on 2020-06-02*/

class NetworkAdapter {

    companion object {

        fun getNetworkService() : NetworkService {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(JSON_PLACEHOLDER_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

            return retrofit.create(NetworkService::class.java)
        }
    }
}