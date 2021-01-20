package com.raeandres.cartrackapp.feature.auth.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.android.BaseActivity
import com.raeandres.cartrackapp.common.utilities.DATA_KEY

class RegistrationActivity : BaseActivity() {

    companion object {
        fun startActivity(origin: Activity, data: Bundle? = null) {
            val intent = Intent(origin, RegistrationActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                putExtra(DATA_KEY,data)
            }
            origin.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}