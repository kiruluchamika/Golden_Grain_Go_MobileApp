package com.example.goldengraingo

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CardAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_add)

        // Bottom navigation listeners
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navSearch = findViewById<LinearLayout>(R.id.navSearch)
        val navCart = findViewById<LinearLayout>(R.id.navCart)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)

        navHome.setOnClickListener { safeStart(MainActivity::class.java, "MainActivity") }
        navSearch.setOnClickListener { safeStart(ProductActivity::class.java, "ProductActivity") }
        navCart.setOnClickListener { safeStart(CartActivity::class.java, "CartActivity") }
        navProfile.setOnClickListener { safeStart(ProfileActivity::class.java, "ProfileActivity") }

        findViewById<Button>(R.id.btnPayNow).setOnClickListener {
            safeStart(PaymentSuccessActivity::class.java, "PaymentSuccessActivity")
        }
    }

    private fun <T> safeStart(clazz: Class<T>, name: String) {
        try {
            startActivity(android.content.Intent(this, clazz))
        } catch (e: Exception) {
            Toast.makeText(this, "$name not found yet.", Toast.LENGTH_SHORT).show()
        }
    }
}
