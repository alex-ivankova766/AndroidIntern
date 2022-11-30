package com.example.androidintern

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val ivBigCat = findViewById<ImageView>(R.id.ivBigCat)
        val bigPhotoLink = intent.getStringExtra("bigPhotoLink")
        Glide.with(this)
            .load(bigPhotoLink)
            .into(ivBigCat)
    }
}