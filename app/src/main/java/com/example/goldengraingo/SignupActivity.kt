package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val fullName = findViewById<TextInputEditText>(R.id.etFullName)
        val email = findViewById<TextInputEditText>(R.id.etEmail)
        val phone = findViewById<TextInputEditText>(R.id.etPhone)
        val password = findViewById<TextInputEditText>(R.id.etPassword)

        findViewById<MaterialButton>(R.id.btnRegister).setOnClickListener {
            // For the lab exam we just navigate; no backend needed
            startActivity(Intent(this, SigninActivity::class.java))
        }

        findViewById<TextView>(R.id.tvLoginNow).setOnClickListener {
            startActivity(Intent(this, SigninActivity::class.java))
        }

        findViewById<ImageView>(R.id.iconGoogle).setOnClickListener {
            Toast.makeText(this, "Google sign-up placeholder", Toast.LENGTH_SHORT).show()
        }
        findViewById<ImageView>(R.id.iconFacebook).setOnClickListener {
            Toast.makeText(this, "Facebook sign-up placeholder", Toast.LENGTH_SHORT).show()
        }
    }
}
