package com.example.ecommerce.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.R
import com.example.ecommerce.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startHomeActivity()
        finish()
    }

    private fun startHomeActivity() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }, 1000)
    }
}