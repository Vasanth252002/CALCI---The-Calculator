package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val time: Long =3800;
        Handler().postDelayed(Runnable {
            val intent = Intent(splashScreen@this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },time)

    }
}