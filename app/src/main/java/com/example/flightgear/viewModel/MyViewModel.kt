package com.example.flightgear.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightgear.model.MyModel
import com.example.flightgear.util.Commands
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    val model: MyModel = MyModel()

    fun setConnection(){
        viewModelScope.launch {
        model.connect(Companion.ip, Companion.port.toInt())
        }
    }

    fun sendCommandAileron(aileron: Float){
        viewModelScope.launch {
            model.send(Commands.Aileron(value = aileron.toDouble()).rCommand)
        }
    }
    fun sendCommandRudder(rudder: Float){
        viewModelScope.launch {
            model.send(Commands.Rudder(value = rudder.toDouble()).rCommand)
        }
    }
    fun sendCommandElevator(elevator: Float){
        viewModelScope.launch {
            model.send(Commands.Elevator(value = elevator.toDouble()).rCommand)
        }
    }
    fun sendCommandEngine(engine: Float){
        viewModelScope.launch {
            model.send(Commands.Engine(value = engine.toDouble()).rCommand)
        }
    }


    companion object {
        const val ip = "10.0.2.2"
        const val port = "6400"
    }
}