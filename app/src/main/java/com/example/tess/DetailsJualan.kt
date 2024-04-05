package com.example.tess

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tess.databinding.ActivityDetailsJualanBinding

class DetailsJualan : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsJualanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsJualanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgfoto = intent.getIntExtra("imgfoto", 0)
        val txtJudul = intent.getStringExtra("txtJudul")
        val txtHarga = intent.getStringExtra("txtHarga")
        val ketDetail = intent.getStringExtra("ketDetail")

        binding.fotodetail.setImageResource(imgfoto)
        binding.juduldetail.text = txtJudul
        binding.hargadetail.text = txtHarga
        binding.ketdetail.text = ketDetail

        binding.btnceckout.setOnClickListener{
            startActivity(Intent(this, RecycviewActivity::class.java))
        }
        binding.backtohome.setOnClickListener{
            startActivity(Intent(this, HomepageActivity::class.java))
        }
    }
}
