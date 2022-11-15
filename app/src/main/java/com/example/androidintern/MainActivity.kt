package com.example.androidintern

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TEN_PERCENT = 10

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btApply)
        val view = findViewById<TextView>(R.id.tvTitle)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val editText = findViewById<EditText>(R.id.edtInput)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        button.setOnClickListener {
            if (checkBox.isChecked && !editText.text.isNullOrBlank()) {
                view.text = editText.text.toString()
                progressBar.progress += TEN_PERCENT
            }
        }
    }
}
