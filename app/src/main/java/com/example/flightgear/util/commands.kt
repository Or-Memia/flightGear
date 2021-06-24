package com.example.flightgear.util

const val base = "set /controls/flight"

sealed class Commands(open val cmd: String, open val value: Double){
    data class Aileron(override val cmd: String = "$base/aileron", override val value: Double):
        Commands(cmd, value)
    val resolvedCommand: String
    get() = "$cmd $value"
}