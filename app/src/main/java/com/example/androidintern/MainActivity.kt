package com.example.androidintern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import timber.log.Timber

private const val LOG_TAG = "MY_LOG"

class MainActivity() : AppCompatActivity() {
    private val url: URL =
        URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread {
            val content = getContent(url)
            Timber.tag(LOG_TAG).d("$content")
        }.start()
    }

    private fun getContent(url: URL): Any {
        val connection = url.openConnection() as HttpsURLConnection
        try {
            connection.requestMethod = "GET"
            connection.readTimeout = 10000
            connection.connect()
            val stream = connection.inputStream
            val reader = BufferedReader(InputStreamReader(stream))
            val buf = StringBuilder()
            do {
                val line: String? = reader.readLine()
                buf.append(line).append("\n")
            } while (reader.readLine() != null)
            return (buf.toString())
        } finally {
            (null as BufferedReader?)?.close()
            (null as InputStream?)?.close()
            connection.disconnect()
        }
    }
}