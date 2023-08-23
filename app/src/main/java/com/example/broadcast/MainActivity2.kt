package com.example.broadcast

import android.app.ApplicationErrorReport.BatteryInfo
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn_next = findViewById<Button>(R.id.button4)
        val send_text = findViewById<EditText>(R.id.inputview1)

        btn_next.setOnClickListener(){
            val str = send_text.text.toString()
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("battery",str)
            startActivity(intent)
        }
    }
}

