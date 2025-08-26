package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    private lateinit var totalCostText: TextView
    private lateinit var placeOrderBtn: Button
    private var totalCost = 950.0 // sample total, should be calculated dynamically

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Find views
        totalCostText = findViewById(R.id.totalCostText)
        placeOrderBtn = findViewById(R.id.placeOrderBtn)
//
//        // Set total cost
//        totalCostText.text = getString(R.string.total_cost, totalCost)

        // Place order button
        placeOrderBtn.setOnClickListener {
//            Toast.makeText(this, "Order placed successfully!", Toast.LENGTH_SHORT).show()
                safeStart(CardAddActivity::class.java, "CardAddActivity")
        }

        // --- Bottom nav listeners ---
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navSearch = findViewById<LinearLayout>(R.id.navSearch)
        val navCart = findViewById<LinearLayout>(R.id.navCart)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)

        navHome.setOnClickListener {
            safeStart(MainActivity::class.java, "MainActivity")
        }

        navSearch.setOnClickListener {
            safeStart(ProductActivity::class.java, "ProductActivity")
        }

        navCart.setOnClickListener {
            // Already here → maybe just toast
            Toast.makeText(this, "You are already in Cart", Toast.LENGTH_SHORT).show()
        }

        navProfile.setOnClickListener {
            safeStart(ProfileActivity::class.java, "ProfileActivity")
        }
    }

    // Reusable safe activity starter
    private fun <T> safeStart(clazz: Class<T>, name: String) {
        try {
            startActivity(Intent(this, clazz))
        } catch (e: Exception) {
            Toast.makeText(this, "$name not found yet.", Toast.LENGTH_SHORT).show()
        }
    }
}
