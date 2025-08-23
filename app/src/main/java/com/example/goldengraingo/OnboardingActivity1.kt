package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding1)

        val nextBtn: Button = findViewById(R.id.btnNext)
        nextBtn.setOnClickListener {
            startActivity(Intent(this, OnboardingActivity2::class.java))
        }
    }
}
