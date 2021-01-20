package com.raeandres.cartrackapp.common.network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


/** Rae-An Andres created on 2021-01-21*/

class ApiCall {

    companion object {
        val INSTANCE = ApiCall()

        val uiScope by lazy {
            CoroutineScope(Dispatchers.Main + Job())
        }

        val ioScope by lazy {
            CoroutineScope(Dispatchers.IO + Job())
        }

        val defaultScope by lazy {
            CoroutineScope(Dispatchers.Default + Job())
        }
    }




}