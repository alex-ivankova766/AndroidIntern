package com.example.androidintern

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber


private const val LOG_TAG = "MY LOG"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button_ok)
        button.setOnClickListener {
            val someText = editText.text.toString()
            Timber.tag(LOG_TAG).d("someText: $someText")
        }
    }
}
