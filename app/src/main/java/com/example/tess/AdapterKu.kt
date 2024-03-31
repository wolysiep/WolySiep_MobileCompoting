package com.example.tess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterKu(private val listPapuan: ArrayList<ItemsGrid>) : RecyclerView.Adapter<AdapterKu.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val juduls: TextView = itemView.findViewById(R.id.title)
        val descs: TextView = itemView.findViewById(R.id.desc)
        val images: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemsgrid, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listPapuan.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = listPapuan[position]
        holder.images.setImageResource(currentItem.images)
        holder.juduls.text = currentItem.juduls
        holder.descs.text = currentItem.descs
    }
}
