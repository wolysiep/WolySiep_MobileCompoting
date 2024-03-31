package com.example.tess

import RecycleViewGridActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tess.databinding.ActivityLoginpageBinding

class LoginpageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnlogin.setOnClickListener{
            startActivity(Intent(this, RecycviewActivity::class.java))
        }
        binding.lupapassword.setOnClickListener{
            startActivity(Intent(this, ForgetpageActivity::class.java))
        }
        binding.buatakun.setOnClickListener{
            startActivity(Intent(this, RegistarpageActivity::class.java))
        }
        binding.backtomain.setOnClickListener{
            startActivity(Intent(this, RecycleViewGridActivity::class.java))
        }

    }
}
