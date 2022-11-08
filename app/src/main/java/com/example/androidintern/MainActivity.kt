package com.example.androidintern

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button_ok)
        button.setOnClickListener {
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, R.string.ok_clicked, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }
}