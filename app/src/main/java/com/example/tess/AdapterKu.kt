package com.example.tess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterKu(private val items: List<ItemsGrid>) : RecyclerView.Adapter<AdapterKu.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imgfotos)
        val title: TextView = itemView.findViewById(R.id.txtjuduls)
        val description: TextView = itemView.findViewById(R.id.txthargas)
        val price: TextView = itemView.findViewById(R.id.txtkilometer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemsgrid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]

        holder.image.setImageResource(currentItem.imageResource)
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.price.text = currentItem.price
    }

    override fun getItemCount() = items.size
}
