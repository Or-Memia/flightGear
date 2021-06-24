package com.example.flightgear.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.flightgear.R
import com.example.flightgear.viewModel.MyViewModel
import com.google.android.material.slider.Slider


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm: MyViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        val btnConnetion = findViewById<Button>(R.id.button)
        // set on-click listener
        btnConnetion.setOnClickListener {
            vm.setConnection()
            val rudder = findViewById<Slider>(R.id.rudder)
        }
    }
}