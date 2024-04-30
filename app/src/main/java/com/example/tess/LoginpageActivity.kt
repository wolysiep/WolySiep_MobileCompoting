package com.example.tess


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tess.databinding.ActivityLoginpageBinding
import com.google.firebase.auth.FirebaseAuth

class LoginpageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginpageBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnlogin.setOnClickListener{
            val email : String = binding.txtemailinput.text.toString().trim()
            val password : String = binding.txtpasswordinput.text.toString().trim()

            if (email.isEmpty()){
                binding.txtemailinput.error = "Masukan email anda!!"
                binding.txtemailinput.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.txtemailinput.error = "Masukan email yang benar!!"
                binding.txtemailinput.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 5){
                binding.txtpasswordinput.error = "Masukan password lebih dari 5 karakter!!"
                binding.txtpasswordinput.requestFocus()
                return@setOnClickListener
            }

            loginUser(email,password)
        }

        binding.lupapassword.setOnClickListener{
           startActivity(Intent(this, ForgetpageActivity::class.java))
           }
        binding.buatakun.setOnClickListener{
            startActivity(Intent(this, RegistarpageActivity::class.java))
        }



    }

    private fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {

                Toast.makeText(this, "Anda berhasil login", Toast.LENGTH_SHORT).show()
                Intent(this, HomepageActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            } else {

                Toast.makeText(this, "Username dan Password salah !!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser !=null){
            Intent(this, HomepageActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}
