package com.ar.bangladeshnewsasik

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.ar.bangladeshnewsasik.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth= FirebaseAuth.getInstance()

        binding.loginHere.setOnClickListener {

            val intent= Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.register.setOnClickListener{
            val firstName=binding.firstName.text.toString()
            val confirmPassword=binding.confirmPassword.text.toString()
            val email=binding.Email.text.toString()
            val passWord=binding.password.text.toString()

            if (email.isNotEmpty() && passWord.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (passWord == confirmPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email ,passWord).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent= Intent(this, Login::class.java)
                            startActivity(intent)

                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                            Toast.makeText(this, "passWord is not matching", Toast.LENGTH_SHORT).show()
                        }
                    } else{
                Toast.makeText(this, "Empty fields are not allowed !!" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}