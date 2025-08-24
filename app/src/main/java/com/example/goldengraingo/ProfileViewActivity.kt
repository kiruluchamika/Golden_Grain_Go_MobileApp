package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)

        // Bottom nav
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navSearch = findViewById<LinearLayout>(R.id.navSearch)
        val navCart = findViewById<LinearLayout>(R.id.navCart)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)

        navHome.setOnClickListener { safeStart(MainActivity::class.java, "MainActivity") }
        navSearch.setOnClickListener { safeStart(ProductActivity::class.java, "ProductActivity") }
        navCart.setOnClickListener { safeStart(CartActivity::class.java, "CartActivity") }
        navProfile.setOnClickListener { safeStart(ProfileViewActivity::class.java, "ProfileViewActivity") }
    }

    private fun <T> safeStart(clazz: Class<T>, name: String) {
        try {
            startActivity(Intent(this, clazz))
        } catch (e: Exception) {
            Toast.makeText(this, "$name not found yet.", Toast.LENGTH_SHORT).show()
        }
    }
}
