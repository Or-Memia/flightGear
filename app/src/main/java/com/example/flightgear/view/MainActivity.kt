package com.example.flightgear.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flightgear.R
import com.example.flightgear.databinding.ActivityMainBinding
import com.example.flightgear.util.Commands
import com.example.flightgear.viewModel.MyViewModel
import com.google.android.material.slider.Slider


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm: MyViewModel by viewModels()
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.viewmodel = vm




//        setContentView(R.layout.activity_main)
//
//         get reference to button
//        val btnConnetion = findViewById<Button>(R.id.button)
//         set on-click listener
//        btnConnetion.setOnClickListener {
//            vm.setConnection()
//            val rudder = findViewById<Slider>(R.id.rudder)
//            rudder.addOnChangeListener { _, amount, _ ->
//                Log.i(":::MainActivity", "rudder = $amount / ${(amount.toInt() * 0.01)}")
//                vm.sendCommand(Commands.Rudder(value = (amount.toInt().toLong()/100)))
//            }
//        }
    }
}