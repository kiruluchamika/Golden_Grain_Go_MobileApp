package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SigninActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val email = findViewById<TextInputEditText>(R.id.etEmail)
        val password = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val tvForgot = findViewById<TextView>(R.id.tvForgot)
        val tvSignup = findViewById<TextView>(R.id.tvSignup)
        val iconGoogle = findViewById<ImageView>(R.id.iconGoogle)
        val iconFacebook = findViewById<ImageView>(R.id.iconFacebook)

        btnLogin.setOnClickListener {
            // For the lab: only navigate (no real auth required)
            startActivity(Intent(this, MainActivity::class.java))
        }

        tvForgot.setOnClickListener {
            Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show()
        }

        tvSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java)) // or WelcomeActivity
        }

        iconGoogle.setOnClickListener {
            Toast.makeText(this, "Google sign-in placeholder", Toast.LENGTH_SHORT).show()
        }
        iconFacebook.setOnClickListener {
            Toast.makeText(this, "Facebook sign-in placeholder", Toast.LENGTH_SHORT).show()
        }
    }
}
