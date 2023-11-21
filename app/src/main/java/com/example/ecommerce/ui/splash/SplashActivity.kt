package com.example.ecommerce.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.ecommerce.R
import com.example.ecommerce.ui.home.HomeActivity
import com.example.ecommerce.ui.login.LoginActivity
import com.example.ecommerce.ui.register.RegisterActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startHomeActivity()
    }

    private fun startHomeActivity() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }, 1000)
    }
}