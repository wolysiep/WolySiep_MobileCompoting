package com.example.tess

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycviewActivity : AppCompatActivity() {
    private lateinit var papuansRecyclerView: RecyclerView
    private lateinit var papuansAdapter: MyAdapter
    private lateinit var listJualan: ArrayList<Items>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        papuansRecyclerView = findViewById(R.id.papuansshopp)
        listJualan = ArrayList()

        // Menambahkan data dummy ke dalam listJualan
        listJualan.add(Items(R.drawable.noken1, "Noken Papua", "Rp.50.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.noken2, "Noken Papua", "Rp.200.0000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.kalung4, "Kalung Papua", "Rp.500.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.noken3, "Noken Papua", "Rp.100.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.noken4, "Noken Papua", "Rp.150.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.kalung3, "Kalung Papua", "Rp.500.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.koteka, "Koteka Papua", "Rp.200.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.koteka2, "Koteka Papua", "Rp.500.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.mahakota1, "Mahakota Papua", "Rp.1000.000", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.mahakota2, "Koteka Papua", "Rp.500.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.kalung2, "Kalung Papua", "Rp.500.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.mahakota3, "Koteka Papua", "Rp.500.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.sali1, "Sali/Rok Papua", "Rp.700.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.sali2, "Sali/Rok Papua", "Rp.500.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))
        listJualan.add(Items(R.drawable.kalung1, "Kalung Papua", "Rp.500.000.00", R.drawable.close, R.drawable.tambahss, R.drawable.like))


        papuansAdapter = MyAdapter(listJualan)
        papuansRecyclerView.layoutManager = LinearLayoutManager(this)
        papuansRecyclerView.adapter = papuansAdapter
    }
}
