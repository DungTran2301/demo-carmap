package com.example.democallcarmap

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {
    private lateinit var btn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button)

        btn.setOnClickListener {
            navToCarmap()
        }
    }

    private fun navToCarmap() {
        val intent = Intent()
        intent.setPackage("vn.carmap")
        intent.action = "vn.carmap.action.search"
        intent.putExtra("query_search", "hồ gươm")
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        intent.component = ComponentName("vn.carmap", "vn.carmap.app.SearchReceiver")
        sendBroadcast(intent)
    }
}