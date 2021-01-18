package com.raeandres.cartrackapp.feature.main.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.feature.auth.ui.AuthActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        finish()
        startActivity(Intent(this,AuthActivity::class.java))
    }
}