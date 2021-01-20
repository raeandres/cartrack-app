package com.raeandres.cartrackapp.feature.auth.login.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.android.BaseActivity
import com.raeandres.cartrackapp.common.utilities.InjectorUtil
import com.raeandres.cartrackapp.common.utilities.RunType
import com.raeandres.cartrackapp.common.utilities.closeKeyboard
import com.raeandres.cartrackapp.feature.main.ui.MainActivity


class LoginActivity : BaseActivity() {

    private lateinit var loginVm : LoginViewModel

    private lateinit var parentLayout: RelativeLayout 
    private lateinit var userName : EditText
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginVm = ViewModelProviders.of(this, InjectorUtil.provideLogin(RunType.FakeData)).get(
            LoginViewModel::class.java
        )
        parentLayout = findViewById(R.id.activity_login)
        userName = findViewById(R.id.username_et)
        password = findViewById(R.id.password_et)
        
    }

    override fun onResume() {
        super.onResume()

        findViewById<Button>(R.id.login_btn).setOnClickListener {

            loginVm.attemptToLogin(this,
                username = userName.text.toString(),
                password = password.text.toString(),
                onSuccess = {
                    //proceed to next screen
                    MainActivity.startActivity(this)
                    finish()
                },
                onError = {
                    // explain the login error
                        errorMessage ->
                    closeKeyboard()
                    Snackbar.make(parentLayout, errorMessage, Snackbar.LENGTH_SHORT).show()
                })
        }
    }
}