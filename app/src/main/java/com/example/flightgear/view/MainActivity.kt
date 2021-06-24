package com.example.flightgear.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flightgear.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        val btnConnetion = findViewById<Button>(R.id.button)
        val myTextView = findViewById<TextView>(R.id.textView)
        var timesClick = 0
        // set on-click listener
        btnConnetion.setOnClickListener {
            timesClick += 1
            Toast.makeText(this@MainActivity, "you clicked me $timesClick", Toast.LENGTH_SHORT).show()
            myTextView.text = timesClick.toString()
        }
    }
}