package com.example.flightgear.model

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.PrintWriter
import java.net.Socket

class MyModel {
    private var socket: Socket? = null
    private var out: PrintWriter? = null
    private val TAG = javaClass.simpleName

    suspend fun connect(ip: String, port: Int) {
        withContext(Dispatchers.IO){
            Log.i(TAG,"before")
            try {
                socket = Socket(ip, port)
                Log.i(TAG,"Client is connected")
                out = PrintWriter(socket!!.getOutputStream(), true)
            } catch (ignored: IOException) {
                Log.e(TAG,"error")
                ignored.printStackTrace()
            }
        }
    }

    suspend fun send(resolvedCommand: String) {
        Log.i(TAG,"received $resolvedCommand")
        withContext(Dispatchers.IO){
            out?.let {
            it.println(resolvedCommand)
            }
        }
    }
}