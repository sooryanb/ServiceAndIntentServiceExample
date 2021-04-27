package com.example.serviceandintentserviceexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    val TAG = "MyService"

    init {
        Log.d(TAG, "Service is running")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG, dataString)
        }

//   Since Service uses UI thread if there is any task that use more time, Do it in another Thread.         
//        Thread {
//
//        }.start()


        return START_STICKY
    }

}