package com.example.androidintern

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidintern.tojson.JSONPhoto
import com.google.gson.Gson
import java.io.IOException
import java.net.URL
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber

private const val URL =
    "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1"
private const val LOG_TAG = "CATS_LOG"
private val client = OkHttpClient()

class MainActivity : AppCompatActivity() {
    val catPhotos = ArrayList<CatPhoto>()
    lateinit var adapter: CatsAdapter
    var activity = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, SecondActivity::class.java)
        adapter = CatsAdapter(this, catPhotos) { bigPhotoLink: String ->
            intent.putExtra("bigPhotoLink", bigPhotoLink)
            startActivity(intent)
        }
        initRV()
        getData(URL(URL))
    }

    private fun getData(link: URL) {

        val request = Request.Builder()
            .url(link)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Timber.tag(LOG_TAG).d(getString(R.string.error))
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("${getString(R.string.error)}, $response")
                    val gson = Gson()
                    val json = response.body!!.string()
                    val test = gson.fromJson(json, JSONPhoto::class.java)
                    Timber.tag(LOG_TAG).d(json)
                    for (photo in test.photos.photo) {
                        catPhotos.add(
                            CatPhoto(
                                "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_m.jpg",
                                "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_z.jpg"
                            )
                        )
                    }
                    activity.runOnUiThread { adapter.notifyDataSetChanged() }
                }
            }
        })
    }

    private fun initRV() {
        val recyclerView: RecyclerView = findViewById(R.id.rvCats)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }
}