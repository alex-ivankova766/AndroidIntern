package com.example.androidintern

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val view = findViewById<TextView>(R.id.text_view)
        val checkBox = findViewById<CheckBox>(R.id.check_box)
        val editText = findViewById<EditText>(R.id.edit_text)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        button.setOnClickListener {
            if (checkBox.isChecked && !TextUtils.isEmpty(editText.text.toString())) {
                view.text = editText.text.toString()
                progressBar.progress += 10
            }
        }
    }
}
