//package com.example.androidintern
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class ColorAdapter(private val colorList: ColorData) : RecyclerView.Adapter<ColorHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
//        val itemView =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
//        return ColorHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
//        holder.bind(colorList.colorNames[position])
//    }
//
//    override fun getItemCount(): Int {
//        return colorList.colorNames.size
//    }
//}
//
//class ColorHolder(colorView: View) : RecyclerView.ViewHolder(colorView) {
//    private var tvColor: TextView = colorView.findViewById(R.id.tvColor)
//    fun bind(colorName: String) {
//        tvColor.text = colorName
//        tvColor.setBackgroundResource(ColorValueMap.getValue(colorName))
//    }
//}
