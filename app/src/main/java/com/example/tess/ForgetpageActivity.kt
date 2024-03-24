package com.example.tess

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tess.databinding.ActivityForgetpageBinding

class ForgetpageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgetpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnubahpassword.setOnClickListener{
            startActivity(Intent(this, LoginpageActivity::class.java))
        }
        binding.backtotologin.setOnClickListener{
            startActivity(Intent(this, LoginpageActivity::class.java))
        }
        binding.btnubahpassword.setOnClickListener{
            startActivity(Intent(this, LoginpageActivity::class.java))
        }
    }
}
