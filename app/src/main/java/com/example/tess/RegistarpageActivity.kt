package com.example.tess

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tess.databinding.ActivityRegistarpageBinding
import com.google.firebase.auth.FirebaseAuth

class RegistarpageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistarpageBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistarpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnregister.setOnClickListener{
            val nama : String = binding.txtnama.text.toString().trim()
            val email : String = binding.txtemail.text.toString().trim()
            val password : String = binding.txtpassword3.text.toString().trim()
            val ulangpassword : String = binding.txtpassword2.text.toString().trim()

            if (nama.isEmpty()){
                binding.txtnama.error ="Masukan nama anda!!"
                binding.txtnama.requestFocus()
                return@setOnClickListener
            }
            if (email.isEmpty()){
                binding.txtemail.error ="Masukan email anda!!"
                binding.txtemail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.txtemail.error ="Masukan email yang benar !!"
                binding.txtemail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 5 ){
                binding.txtpassword3.error = "Password harus lebih dari 5 karakter!!"
                binding.txtpassword3.requestFocus()
                return@setOnClickListener
            }
            if (password != ulangpassword){
                binding.txtpassword2.error = "Password Harus sama dengan sebelumnya!!"
                binding.txtpassword2.requestFocus()
                return@setOnClickListener
            }
            registerUser(email, password)
        }

        binding.backlogin.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Intent(this, LoginpageActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Selamat anda sudah punya akun !!", Toast.LENGTH_SHORT).show()

                binding.txtnama.text.clear()
                binding.txtemail.text.clear()
                binding.txtpassword3.text.clear()
                binding.txtpassword2.text.clear()
            } else {
                Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }





    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser !=null){
            Intent(this, HomepageActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}
