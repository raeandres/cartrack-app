package com.raeandres.cartrackapp.feature.auth.login.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.android.BaseActivity
import com.raeandres.cartrackapp.common.utilities.*
import com.raeandres.cartrackapp.feature.countries.ui.CountrySelectionActivity
import com.raeandres.cartrackapp.feature.main.ui.MainActivity

class LoginActivity : BaseActivity() {

    companion object {
        fun startActivity(origin: Activity, data: Bundle) {
            val intent = Intent(origin,LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                putExtra(DATA_KEY,data)
            }
            origin.startActivity(intent)
        }
    }

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

        intent?.extras?.let { bund ->
           val bundle = bund.getBundle(DATA_KEY)

            bundle?.also {
                findViewById<TextView>(R.id.country_prefix_tv).text = it.get(COUNTRY_PREFIX_KEY).toString()
                findViewById<TextView>(R.id.country_flag_tv).text = it.get(COUNTRY_FLAG_KEY).toString()
            }

        }
        
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

        findViewById<RelativeLayout>(R.id.select_country_layout).setOnClickListener {
            closeKeyboard()
            CountrySelectionActivity.startActivity(this)
        }
    }
}