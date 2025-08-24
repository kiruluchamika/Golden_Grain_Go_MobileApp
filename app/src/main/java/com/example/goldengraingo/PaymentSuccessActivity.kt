package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class PaymentSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_success)

        // Bottom nav listeners
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navSearch = findViewById<LinearLayout>(R.id.navSearch)
        val navCart = findViewById<LinearLayout>(R.id.navCart)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)

        navHome.setOnClickListener { safeStart(MainActivity::class.java) }
        navSearch.setOnClickListener { safeStart(ProductActivity::class.java) }
        navCart.setOnClickListener { safeStart(CartActivity::class.java) }
        navProfile.setOnClickListener { safeStart(ProfileActivity::class.java) }
    }

    private fun <T> safeStart(clazz: Class<T>) {
        startActivity(Intent(this, clazz))
    }
}
