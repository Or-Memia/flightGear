package com.example.flightgear.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flightgear.R
import com.example.flightgear.databinding.ActivityMainBinding
import com.example.flightgear.viewModel.MyViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm: MyViewModel by viewModels()
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.viewmodel = vm

        binding.joystick.setJListener{ a, e ->
            vm.sendCommandAileron(a)
            vm.sendCommandElevator(e)
        }
    }
}