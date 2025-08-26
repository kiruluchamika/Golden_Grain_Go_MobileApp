package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val welcomeText = findViewById<TextView>(R.id.txtWelcome)
        welcomeText.text = getString(R.string.welcome_user, "Ck")

        // Bottom nav listeners
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navSearch = findViewById<LinearLayout>(R.id.navSearch)
        val navCart = findViewById<LinearLayout>(R.id.navCart)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)

        navHome.setOnClickListener { safeStart(MainActivity::class.java, "MainActivity") }
        navSearch.setOnClickListener { safeStart(ProductActivity::class.java, "ProductActivity") }
        navCart.setOnClickListener { safeStart(CartActivity::class.java, "CartActivity") }
        navProfile.setOnClickListener { safeStart(ProfileActivity::class.java, "ProfileActivity") }

        // Button navigations
        findViewById<Button>(R.id.btnProducts).setOnClickListener {
            safeStart(ProductActivity::class.java, "ProductActivity")
        }

        findViewById<Button>(R.id.btnProfile1).setOnClickListener {
            safeStart(ProfileViewActivity::class.java, "ProfileViewActivity")
        }

        findViewById<Button>(R.id.btnSettings).setOnClickListener {
            safeStart(SettingsActivity::class.java, "SettingsActivity")
        }
    }

    private fun <T> safeStart(clazz: Class<T>, name: String) {
        try {
            startActivity(Intent(this, clazz))
        } catch (e: Exception) {
            Toast.makeText(this, "$name not found yet.", Toast.LENGTH_SHORT).show()
        }
    }
}
