package com.example.androidintern

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val view = findViewById<TextView>(R.id.view)
        button.setOnClickListener {
            view.setText(R.string.button_pressed)
        }
    }
}
