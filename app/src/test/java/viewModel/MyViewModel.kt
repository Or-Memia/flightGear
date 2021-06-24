package viewModel
import androidx.lifecycle.ViewModel
import model.MyModel

class MyViewModel : ViewModel() {
    val model: MyModel = MyModel()
    var ip = ""
    var port = ""

    fun setConnection(){
        model.connect(ip, port.toInt())
    }
}