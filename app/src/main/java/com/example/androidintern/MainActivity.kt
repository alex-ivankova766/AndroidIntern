package com.example.androidintern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidintern.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: PhonesAdapter
    lateinit var phonesList: List<PhoneItem>
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gson = Gson()
        phonesList = gson.fromJson(jsonString, Array<PhoneItem>::class.java).asList()
        adapter = PhonesAdapter(phonesList)
        recyclerView = findViewById(R.id.rvPhones)
        initRV()
        binding.btApply.setOnClickListener {
            if (!binding.etFilterText.text.isNullOrBlank()) {
                val filteredPhoneList =
                    phonesList.filter { binding.etFilterText.text in it.phone || binding.etFilterText.text in it.name || binding.etFilterText.text in it.type }
                adapter = PhonesAdapter(filteredPhoneList)
                initRV()
            }
        }
    }

    private fun initRV() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}