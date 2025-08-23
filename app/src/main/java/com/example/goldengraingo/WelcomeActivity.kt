package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        findViewById<MaterialButton>(R.id.btnSignup).setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
        findViewById<MaterialButton>(R.id.btnSignin).setOnClickListener {
            startActivity(Intent(this, SigninActivity::class.java))
        }
        findViewById<TextView>(R.id.guestText).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java)) // or Home
        }
    }
}
