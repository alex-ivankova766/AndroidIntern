package com.example.androidintern

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity(
    val colorList: List<String> = listOf(
        "Red",
        "Orange",
        "Yellow",
        "Green",
        "Lightblue",
        "Blue",
        "Purple"
    )
) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRV()
    }

    private fun initRV() {
        val recycleView: RecyclerView = findViewById(R.id.rvColors)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = ColorAdapter(colorList) { data: String ->
            Toast.makeText(
                this,
                data,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

