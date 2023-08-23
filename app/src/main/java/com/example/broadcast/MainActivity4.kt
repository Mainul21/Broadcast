package com.example.broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val btn_custom = findViewById<Button>(R.id.button_custom)
        val input_custom = findViewById<EditText>(R.id.inputview_custom)

        btn_custom.setOnClickListener(){
            val string = input_custom.text.toString()
            val intent = Intent(this,MainActivity3::class.java)
            intent.putExtra("message_key",string)
            startActivity(intent)

        }
        }
    }

