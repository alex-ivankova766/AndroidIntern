package com.example.androidintern

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

val colorValueMap = mapOf(
    "Red" to R.color.red,
    "Orange" to R.color.orange,
    "Yellow" to R.color.yellow,
    "Green" to R.color.green,
    "Lightblue" to R.color.lightblue,
    "Blue" to R.color.blue,
    "Purple" to R.color.purple
)

class ColorAdapter(
    private val colorList: List<String>,
    private var callBackListener: (String) -> Unit
) : RecyclerView.Adapter<ColorAdapter.ColorHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        return ColorHolder(itemView)
    }

    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        holder.bind(colorList[position], callBackListener)
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    class ColorHolder(colorView: View) : RecyclerView.ViewHolder(colorView) {
        private var tvColor: TextView = colorView.findViewById(R.id.tvColor)

        fun bind(colorName: String, callBackListener: (String) -> Unit) {
            tvColor.text = colorName
            tvColor.setBackgroundResource(colorValueMap.getValue(colorName))
            itemView.setOnClickListener {
                callBackListener(colorName)
            }
        }
    }
}


