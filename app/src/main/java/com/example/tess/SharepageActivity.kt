package com.example.tess

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tess.databinding.ActivitySharepageBinding

class SharepageActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val toGoogleImageView = findViewById<ImageView>(R.id.togoogle)
        val toInstagramImageView = findViewById<ImageView>(R.id.toig)
        val toLinkImageView = findViewById<ImageView>(R.id.tolink)
        val toFacebookImageView = findViewById<ImageView>(R.id.tofb)


        toGoogleImageView.setOnClickListener {
            val uri = Uri.parse("https://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }


        toInstagramImageView.setOnClickListener {
            val uri = Uri.parse("https://www.instagram.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }


        toLinkImageView.setOnClickListener {
            val uri = Uri.parse("https://www.linkeding.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        toFacebookImageView.setOnClickListener {
            val uri = Uri.parse("https://www.facebook.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        val btnShare = findViewById<Button>(R.id.btnshare)

        btnShare.setOnClickListener {

            val nama = binding.inputnama.text.toString()
            val nomor = binding.inputtelepon.text.toString()
            val pesan = binding.inputpesan.text.toString()


            val uri = Uri.parse("https://wa.me/$nomor/?text=Hallo......\n Perkenalkan saya:  $nama,\n \n $pesan")

            val intent = Intent(Intent.ACTION_VIEW, uri)


            startActivity(intent)
        }

        binding.imgberandas.setOnClickListener{
            startActivity(Intent(this, HomepageActivity::class.java))
        }
        binding.imgkeranjangs.setOnClickListener{
            startActivity(Intent(this, RecycviewActivity::class.java))
        }
        binding.imgpesans.setOnClickListener{
            startActivity(Intent(this, SharepageActivity::class.java))
        }
        binding.imgakuns.setOnClickListener{
            startActivity(Intent(this, ProfilepageActicity::class.java))
        }
    }
}



