package com.raeandres.cartrackapp.feature.auth.login.ui

import android.os.Bundle
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.android.BaseActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initialize()

    }

    private fun initialize(){

    }
}