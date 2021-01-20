package com.raeandres.cartrackapp.common.utilities

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

fun Activity.closeKeyboard() {
    this.currentFocus?.apply {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.windowToken, 0)
    }
}