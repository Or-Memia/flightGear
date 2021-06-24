package com.example.flightgear.util

const val base = "set /controls/flight"
const val engine = "set /controls/flight/current-engine/throttle"

sealed class Commands(open val cmd: String, open val value: Double) {
    data class Aileron(override val cmd: String = "$base/aileron", override val value: Double) : Commands(cmd, value)
    data class Elevator(override val cmd: String = "$base/elevator", override val value: Double) : Commands(cmd, value)
    data class Rudder(override val cmd: String = "$base/rudder", override val value: Double) : Commands(cmd, value)
    data class Engine(override val cmd: String = "$base/engine", override val value: Double) : Commands(cmd, value)

    val rCommand: String
        get() = "$cmd $value"
}