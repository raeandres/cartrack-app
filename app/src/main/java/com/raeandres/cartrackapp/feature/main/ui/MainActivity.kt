package com.raeandres.cartrackapp.feature.main.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.android.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        fun startActivity(origin: Context) {
            origin.startActivity(Intent(origin,MainActivity::class.java))
        }
    }
}