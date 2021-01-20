package com.raeandres.cartrackapp.common.utilities

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.raeandres.cartrackapp.common.android.CarTrackApp
import java.io.File
import java.io.IOException

fun Activity.closeKeyboard() {
    this.currentFocus?.apply {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.windowToken, 0)
    }
}

object AndroidUtil {

    fun getJsonDataFromAsset(fileName: String): String? {
        val app = CarTrackApp.instance
        val jsonString: String
        try {
            jsonString = app.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}

