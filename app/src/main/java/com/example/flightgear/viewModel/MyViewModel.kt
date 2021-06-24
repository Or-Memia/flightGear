package com.example.flightgear.viewModel
import androidx.lifecycle.ViewModel
import com.example.flightgear.model.MyModel

class MyViewModel : ViewModel() {
    val model: MyModel = MyModel()
    var ip = ""
    var port = ""

    fun setConnection(){
        model.connect(ip, port.toInt())
    }
}