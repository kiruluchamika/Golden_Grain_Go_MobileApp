package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaymentCardsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_cards)

        // Back
        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        // Delete toasts (stub)
        findViewById<TextView>(R.id.deleteVisa).setOnClickListener {
            Toast.makeText(this, getString(R.string.deleted, "Visa"), Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.deleteMaster).setOnClickListener {
            Toast.makeText(this, getString(R.string.deleted, "Mastercard"), Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.deletePaypal).setOnClickListener {
            Toast.makeText(this, getString(R.string.deleted, "PayPal"), Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.deleteApple).setOnClickListener {
            Toast.makeText(this, getString(R.string.deleted, "Apple Pay"), Toast.LENGTH_SHORT).show()
        }

        // Add flows (stub)
        findViewById<LinearLayout>(R.id.addCard).setOnClickListener {
            Toast.makeText(this, getString(R.string.add_flow, getString(R.string.credit_or_debit_card)), Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.addPaypal).setOnClickListener {
            Toast.makeText(this, getString(R.string.add_flow, getString(R.string.paypal)), Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.addApple).setOnClickListener {
            Toast.makeText(this, getString(R.string.add_flow, getString(R.string.apple_pay)), Toast.LENGTH_SHORT).show()
        }

        // Bottom nav
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navSearch = findViewById<LinearLayout>(R.id.navSearch)
        val navCart = findViewById<LinearLayout>(R.id.navCart)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)

        navHome.setOnClickListener { safeStart(MainActivity::class.java, "MainActivity") }
        navSearch.setOnClickListener { safeStart(ProductActivity::class.java, "ProductActivity") }
        navCart.setOnClickListener { safeStart(CartActivity::class.java, "CartActivity") }
        navProfile.setOnClickListener { safeStart(ProfileActivity::class.java, "ProfileActivity") }
    }

    private fun <T> safeStart(clazz: Class<T>, name: String) {
        try { startActivity(Intent(this, clazz)) }
        catch (e: Exception) {
            Toast.makeText(this, "$name not found yet.", Toast.LENGTH_SHORT).show()
        }
    }
}
