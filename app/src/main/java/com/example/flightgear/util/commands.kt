package com.example.flightgear.util

import kotlin.math.round

const val base = "set /controls/flight"
const val engine = "set /controls/engines/current-engine/throttle"

sealed class Commands(open val cmd: String, open val value: Double) {
    data class Aileron(override val cmd: String = "$base/aileron", override val value: Double) :
        Commands(cmd, value)

    data class Elevator(override val cmd: String = "$base/elevator", override val value: Double) :
        Commands(cmd, value)

    data class Rudder(override val cmd: String = "$base/rudder", override val value: Double) :
        Commands(cmd, value)

    data class Engine(override val cmd: String = engine, override val value: Double) :
        Commands(cmd, value)

    val rCommand: String
        get() = "$cmd ${round(value * 100) / 100}"
}