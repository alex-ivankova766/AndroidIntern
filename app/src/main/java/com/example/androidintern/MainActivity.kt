package com.example.androidintern

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val colorList = listOf("Red", "Orange", "Yellow", "Green", "Lightblue", "Blue", "Purple")

class MainActivity : AppCompatActivity(), ColorAdapter.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRV()
    }

    override fun onClick(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }

    private fun initRV() {
        val recycleView: RecyclerView = findViewById(R.id.rvColors)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = ColorAdapter(colorList, this)
    }
}

