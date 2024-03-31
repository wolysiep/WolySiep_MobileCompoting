package com.example.tess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val listPapuans: ArrayList<Items>) : RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambar1: ImageView = itemView.findViewById(R.id.imgshops)
        val gambar2: ImageView = itemView.findViewById(R.id.imgcloses)
        val gambar3: ImageView = itemView.findViewById(R.id.imgtambah)
        val gambar4: ImageView = itemView.findViewById(R.id.imglike)
        val judul: TextView = itemView.findViewById(R.id.txtjudul)
        val harga: TextView = itemView.findViewById(R.id.txtharga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listPapuans.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = listPapuans[position]
        holder.gambar1.setImageResource(currentItem.gambar1)
        holder.gambar2.setImageResource(currentItem.gambar2)
        holder.gambar3.setImageResource(currentItem.gambar3)
        holder.gambar4.setImageResource(currentItem.gambar4)
        holder.judul.text = currentItem.judul
        holder.harga.text = currentItem.harga
    }
}
