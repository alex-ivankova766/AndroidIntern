package com.example.androidintern

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_second, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.itemLike) {
            super.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}