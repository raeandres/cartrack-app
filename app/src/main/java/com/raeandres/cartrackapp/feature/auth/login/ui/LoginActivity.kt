package com.raeandres.cartrackapp.feature.auth.login.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.android.BaseActivity
import com.raeandres.cartrackapp.feature.main.ui.MainActivity

class LoginActivity : BaseActivity() {

    private lateinit var loginVm : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginVm = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        val parentLayout = findViewById<RelativeLayout>(R.id.activity_login)
        val userName = findViewById<EditText>(R.id.username_et).text.toString()
        val password = findViewById<EditText>(R.id.password_et).text.toString()

        findViewById<Button>(R.id.login_btn).setOnClickListener { onClick ->

           loginVm.attemptToLogin(this, username = userName, password = password,
               onSuccess = {
                      //proceed to next screen
                           MainActivity.startActivity(this)
               },
                onError = {
                    // explain the login error
                    errorMessage ->
                   Snackbar.make(parentLayout,errorMessage,Snackbar.LENGTH_SHORT).show()
                })
        }
    }
}