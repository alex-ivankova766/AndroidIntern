package com.example.androidintern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRV()
    }

    private fun initRV() {
        val recycleView: RecyclerView = findViewById(R.id.rvColors)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = ColorAdapter(ColorList)
    }
}

