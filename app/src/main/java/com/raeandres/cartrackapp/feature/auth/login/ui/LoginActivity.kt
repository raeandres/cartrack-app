package com.raeandres.cartrackapp.feature.auth.login.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.android.BaseActivity
import com.raeandres.cartrackapp.common.utilities.InjectorUtils
import com.raeandres.cartrackapp.feature.auth.login.model.LoginViewModel

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initialize()

    }

    private fun initialize(){
        val factory = InjectorUtils.provideLoginVmFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(LoginViewModel::class.java)

        viewModel.getUserLogin().observe(this, Observer {
            loginData ->

        })
    }
}