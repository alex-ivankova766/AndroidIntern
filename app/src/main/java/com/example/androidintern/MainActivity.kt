package com.example.androidintern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.net.URL
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber

private const val LOG_TAG = "MY_LOG"
private const val TASK_URL =
    "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1"
private val client = OkHttpClient()

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        val request = Request.Builder()
            .url(URL(TASK_URL))
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Timber.tag(LOG_TAG).d(getString(R.string.error))
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("${R.string.error} $response")
                    Timber.tag(LOG_TAG).d(response.body!!.string())
                }
            }
        })
    }
}