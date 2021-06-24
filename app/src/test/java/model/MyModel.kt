package model

import java.io.IOException
import java.io.PrintWriter
import java.net.Socket

class MyModel {
    private var socket: Socket? = null
    private var out: PrintWriter? = null

    fun connect(ip: String, port: Int) {
        Thread {
            println("before")
            try{
               socket = Socket(ip, port)
               println("Client is connected")
               out = PrintWriter(socket!!.getOutputStream(),true)
            }
            catch (ignored: IOException)
            {
                println("error")
                ignored.printStackTrace()
            }
        }.start()
    }
}