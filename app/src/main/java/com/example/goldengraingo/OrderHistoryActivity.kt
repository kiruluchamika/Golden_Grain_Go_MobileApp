package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_history)

        // Back
        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        // Bottom nav
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navSearch = findViewById<LinearLayout>(R.id.navSearch)
        val navCart = findViewById<LinearLayout>(R.id.navCart)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)

        navHome?.setOnClickListener { safeStart(MainActivity::class.java, "MainActivity") }
        navSearch?.setOnClickListener { safeStart(ProductActivity::class.java, "ProductActivity") }
        navCart?.setOnClickListener { safeStart(CartActivity::class.java, "CartActivity") }
        navProfile?.setOnClickListener { safeStart(ProfileActivity::class.java, "ProfileActivity") }

        // Highlight current tab (Profile or History depending where you want)
        navProfile?.alpha = 1f
        navHome?.alpha = 0.6f
        navSearch?.alpha = 0.6f
        navCart?.alpha = 0.6f

        findViewById<LinearLayout>(R.id.ss).setOnClickListener {
            safeStart(OrderTrackingActivity::class.java, "OrderTrackingActivity")
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
