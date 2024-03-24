package com.example.tess

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tess.databinding.ActivityRegistarpageBinding

class RegistarpageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistarpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistarpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backlogin.setOnClickListener {
            startActivity(Intent(this, LoginpageActivity::class.java))
        }
        binding.btnregister.setOnClickListener {
            startActivity(Intent(this, LoginpageActivity::class.java))
        }
    }
}
