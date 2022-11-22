package com.example.androidintern

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.androidintern.databinding.ActivityMainBinding

private const val URL = "https://bigpicture.ru/wp-content/uploads/2012/04/2184.jpg"

class MainActivity() : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageView = findViewById<ImageView>(R.id.ivPhotoFromUrl)
        binding.btActivitySwitch.setOnClickListener {
            setContentView(R.layout.photo_from_url)
            Glide.with(this)
                .load(URL)
                .into(imageView)
        }
    }
}