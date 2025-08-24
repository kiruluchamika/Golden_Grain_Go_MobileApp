package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bottom nav listeners (from included layout)
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navSearch = findViewById<LinearLayout>(R.id.navSearch)
        val navCart = findViewById<LinearLayout>(R.id.navCart)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)

        navHome.setOnClickListener {
            // Already here; optionally scroll to top
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
        }

        navSearch.setOnClickListener {
            safeStart(ProductActivity::class.java, "ProductActivity")
        }

        navCart.setOnClickListener {
            safeStart(CartActivity::class.java, "CartActivity")
        }

        navProfile.setOnClickListener {
            safeStart(ProfileActivity::class.java, "ProfileActivity")
        }
    }

    private fun <T> safeStart(clazz: Class<T>, name: String) {
        try {
            startActivity(Intent(this, clazz))
        } catch (e: Exception) {
            // In case the target Activity isn't created yet, avoid crashing
            Toast.makeText(this, "$name not found yet.", Toast.LENGTH_SHORT).show()
        }
    }
}
