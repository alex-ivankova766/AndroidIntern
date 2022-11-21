package com.example.androidintern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedInputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import timber.log.Timber

private const val LOG_TAG = "MY_LOG"
private const val TASK_URL =
    "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1"

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread {
            val urlConnection = URL(TASK_URL).openConnection() as HttpsURLConnection
            try {
                BufferedInputStream(urlConnection.inputStream).bufferedReader().use {
                    Timber.tag(LOG_TAG).d(it.readText())
                }
            } finally {
                urlConnection.disconnect()
            }
        }.start()
    }
}