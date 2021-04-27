package com.example.serviceandintentserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnStart: Button
    lateinit var btnStop: Button
    lateinit var btnSend : Button
    lateinit var textData : EditText
    lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)
        btnSend = findViewById(R.id.btnSendData)
        textData = findViewById(R.id.etvData)
        statusText = findViewById(R.id.tvStatus)

        btnStart.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                statusText.text = "Service Started"
            }
        }

        btnStop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                statusText.text = "Service Stopped"
            }
        }

        btnSend.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = textData.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }

    }
}