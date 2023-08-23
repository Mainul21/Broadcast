package com.example.broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_custom = findViewById<Button>(R.id.button1)
        val btn_battery = findViewById<Button>(R.id.button3)
        val btn_wifi = findViewById<Button>(R.id.button2)


        btn_custom.setOnClickListener(){
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        btn_battery.setOnClickListener(){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        btn_wifi.setOnClickListener(){
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}