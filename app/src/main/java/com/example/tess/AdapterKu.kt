// AdapterKu.kt
package com.example.tess

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

@Suppress("NAME_SHADOWING")
class AdapterKu(private val context: Context, private val courseList: List<DataKu>) : BaseAdapter() {

    override fun getCount(): Int {
        return courseList.size
    }

    override fun getItem(position: Int): Any {
        return courseList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val viewHolder: ViewHolder

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_items, parent, false)
            viewHolder = ViewHolder()
            viewHolder.judulJualan = convertView.findViewById(R.id.Judul)
            viewHolder.hargaJualan = convertView.findViewById(R.id.Harga)
            viewHolder.gambarJualan = convertView.findViewById(R.id.Foto)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        val currentCourse = courseList[position]

        viewHolder.judulJualan.text = currentCourse.txtJudul
        viewHolder.hargaJualan.text = currentCourse.txtHarga
        viewHolder.gambarJualan.setImageResource(currentCourse.imgfoto)

        convertView!!.setOnClickListener {
            val intent = Intent(context, DetailsJualan::class.java).apply {
                putExtra("txtJudul", currentCourse.txtJudul)
                putExtra("txtHarga", currentCourse.txtHarga)
                putExtra("imgfoto", currentCourse.imgfoto)
                putExtra("ketDetail", currentCourse.ketDetail)

            }
            context.startActivity(intent)
        }

        return convertView
    }

    private class ViewHolder {
        lateinit var judulJualan: TextView
        lateinit var hargaJualan: TextView
        lateinit var gambarJualan: ImageView
    }
}
