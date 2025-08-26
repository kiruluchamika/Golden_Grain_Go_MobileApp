package com.example.goldengraingo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // If your file name is different, update the layout ID accordingly.
        setContentView(R.layout.activity_settings)

        // Back
        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        // Static placeholders
        findViewById<TextView>(R.id.txtLanguageValue).text = "English"
        findViewById<TextView>(R.id.txtThemeValue).text = "System"

        // Row clicks
        findViewById<LinearLayout>(R.id.rowAccountDetails).setOnClickListener {
            safeStart(ProfileViewActivity::class.java, "ProfileViewActivity")
        }
        findViewById<LinearLayout>(R.id.rowAppLanguage).setOnClickListener {
            Toast.makeText(this, "Language picker coming soon", Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.rowAppTheme).setOnClickListener {
            Toast.makeText(this, "Theme selector coming soon", Toast.LENGTH_SHORT).show()
        }

        // Logout action
        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
            safeStart(WelcomeActivity::class.java, "WelcomeActivity")
            finishAffinity()
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
