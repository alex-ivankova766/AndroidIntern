package com.example.androidintern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidintern.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity() {
    lateinit var bndActivityMain: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bndActivityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bndActivityMain.root)
        bndActivityMain.bt.setOnClickListener {
            bndActivityMain.tvResult.text = bndActivityMain.edt.text
        }
    }
}