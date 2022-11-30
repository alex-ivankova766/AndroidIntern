package com.example.androidintern

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhonesAdapter(private val phones: List<PhoneItem>) :
    RecyclerView.Adapter<PhonesAdapter.PhonesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_phone, parent, false)
        return PhonesHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhonesHolder, position: Int) {
        holder.bind(phones[position])
    }

    override fun getItemCount(): Int {
        return phones.size
    }

    class PhonesHolder(phoneView: View) : RecyclerView.ViewHolder(phoneView) {
        private val tvName: TextView = phoneView.findViewById(R.id.tvName)
        private val tvPhone: TextView = phoneView.findViewById(R.id.tvPhone)
        private val tvType: TextView = phoneView.findViewById(R.id.tvType)
        fun bind(phone: PhoneItem) {
            tvName.text = phone.name
            tvPhone.text = phone.phone
            tvType.text = phone.type
        }
    }
}