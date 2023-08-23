package com.example.broadcast



import android.annotation.SuppressLint

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Switch
import android.widget.TextView
import android.widget.Toast


class MainActivity3 : AppCompatActivity() {



    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var wifi:Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val guess = findViewById<TextView>(R.id.textView4)
        wifi = findViewById<Switch>(R.id.switch1)

        val intent = intent
        val string =intent.getStringExtra("battery")
        guess.text = string.toString()


        registerReceiver(this.Batteryinfo, IntentFilter(Intent.ACTION_BATTERY_CHANGED))


        val str = intent.getStringExtra("message_key")
        Toast.makeText(this,str.toString(),Toast.LENGTH_SHORT).show()

    }

    private val Wifistate:BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val wifiStateExtra = intent!!.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN)
            if (wifiStateExtra == WifiManager.WIFI_STATE_ENABLED){
                wifi.setChecked(true)
                wifi.text = "Wifi On"
            }
            else if (wifiStateExtra == WifiManager.WIFI_STATE_DISABLED){
                wifi.setChecked(false)
                wifi.text = "Wifi Off"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val intentfliter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(Wifistate,intentfliter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(Wifistate)
    }

    private val Batteryinfo: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val tv = findViewById<TextView>(R.id.textView3)
            val battery = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            tv.text = battery.toString()
        }

    }
}




