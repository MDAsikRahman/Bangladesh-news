package com.ar.bangladeshnewsasik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ar.bangladeshnewsasik.databinding.ActivityMainBinding
import com.ar.bangladeshnewsasik.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}