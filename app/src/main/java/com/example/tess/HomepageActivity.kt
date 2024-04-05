// HomepageActivity.kt
package com.example.tess

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.tess.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomepageBinding
    private lateinit var bransKu: GridView
    private lateinit var listJualans: List<DataKu>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bransKu = binding.papuans
        listJualans = listOf(
            DataKu("Mhkta Papua", "Rp.200.000", R.drawable.mahakota1, getString(R.string.mahakota)),
            DataKu("Mhkta Papua", "Rp.100.000", R.drawable.mahakota2, getString(R.string.mahakota)),
            DataKu("Mhkta Papua", "Rp.200.000", R.drawable.mahakota3, getString(R.string.mahakota)),
            DataKu("Noken Papua", "Rp.400.000", R.drawable.noken1, getString(R.string.noken)),
            DataKu("Noken Papua", "Rp.200.000", R.drawable.noken2, getString(R.string.noken)),
            DataKu("Noken Papua", "Rp.500.000", R.drawable.noken3, getString(R.string.noken)),
            DataKu("Noken Papua", "Rp.200.000", R.drawable.noken4,  getString(R.string.noken)),
            DataKu("Koteka Papua", "Rp.200.000", R.drawable.koteka, getString(R.string.koteka)),
            DataKu("Koteka Papua", "Rp.200.000", R.drawable.koteka2, getString(R.string.koteka)),
            DataKu("Salih Papua", "Rp.200.000", R.drawable.sali1, getString(R.string.salih)),
            DataKu("Salih Papua", "Rp.200.000", R.drawable.sali2, getString(R.string.salih)),
            DataKu("Kalung Papua", "Rp.200.000", R.drawable.kalung1, getString(R.string.kalung)),
            DataKu("Kalung Papua", "Rp.200.000", R.drawable.kalung2, getString(R.string.kalung)),
            DataKu("Kalung Papua", "Rp.200.000", R.drawable.kalung3, getString(R.string.kalung)),
            DataKu("Kalung Papua", "Rp.200.000", R.drawable.kalung4, getString(R.string.kalung))
        )

        val courseAdapter = AdapterKu(this@HomepageActivity, listJualans)
        bransKu.adapter = courseAdapter

        // Intent
        binding.imgberandas.setOnClickListener {
            startActivity(Intent(this, HomepageActivity::class.java))
        }
        binding.imgkeranjangs.setOnClickListener {
            startActivity(Intent(this, RecycviewActivity::class.java))
        }
        binding.imgpesans.setOnClickListener {
            startActivity(Intent(this, SharepageActivity::class.java))
        }
        binding.imgakuns.setOnClickListener {
            startActivity(Intent(this, ProfilepageActicity::class.java))
        }
    }
}
