package com.example.androidintern

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CatsAdapter(
    private val context: Context, private val catsList: MutableList<CatPhoto>, private val onCatClick: (String) -> Unit) : RecyclerView.Adapter<CatsAdapter.CatsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatsHolder(itemView)
    }

    override fun onBindViewHolder(holder: CatsHolder, position: Int) {
        holder.bind(context, catsList[position], onCatClick)
    }

    override fun getItemCount(): Int {
        return catsList.size
    }

    class CatsHolder(catView: View) : RecyclerView.ViewHolder(catView) {
        private val ivCats: ImageView = catView.findViewById(R.id.ivCats)
        fun bind(context: Context, catPhoto: CatPhoto, onCatClick: (String) -> Unit) {
            Glide.with(context)
                .load(catPhoto.smallPhotoUrl)
                .into(ivCats)
            itemView.setOnClickListener {
                onCatClick(catPhoto.bigPhotoUrl)
            }
        }
    }
}
