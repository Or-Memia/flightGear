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

    fun sendCommand(command: Commands){
        model.send(command.resolvedCommand)
    }

    companion object {
        const val ip = "127.0.0.1"
        const val port = "6400"
    }
}