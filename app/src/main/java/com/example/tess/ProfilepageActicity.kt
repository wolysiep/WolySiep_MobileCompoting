package com.example.tess

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tess.databinding.ActivityProfilepageActicityBinding
import com.google.firebase.auth.FirebaseAuth

class ProfilepageActicity : AppCompatActivity() {
    private lateinit var binding: ActivityProfilepageActicityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilepageActicityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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
        binding.logouts.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            Intent(this, LoginpageActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }

    }
}
