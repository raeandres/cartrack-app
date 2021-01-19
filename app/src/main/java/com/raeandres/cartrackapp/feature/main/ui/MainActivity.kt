package com.raeandres.cartrackapp.feature.main.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raeandres.cartrackapp.R

class MainActivity : AppCompatActivity() {

    companion object {
        fun startActivity(origin: AppCompatActivity) {
            origin.startActivity(Intent(origin,this::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}