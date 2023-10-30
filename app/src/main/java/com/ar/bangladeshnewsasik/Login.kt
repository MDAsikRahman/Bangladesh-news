package com.ar.bangladeshnewsasik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ar.bangladeshnewsasik.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginText.setOnClickListener {
            val intent=Intent(this,Register::class.java)
            startActivity(intent)
        }
        binding.login.setOnClickListener {
            val userName=binding.userName.text.toString()
            val email=binding.Email.text.toString()
            val passWord=binding.password.text.toString()

            if (email.isNotEmpty() && passWord.isNotEmpty()){

                    firebaseAuth.signInWithEmailAndPassword(email ,passWord).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent= Intent(this, MainActivity::class.java)
                            startActivity(intent)

                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "passWord is not matching", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
