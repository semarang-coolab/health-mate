package com.bangkit.semarangcoolab.health_mate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

@Suppress("DEPRECATION")
class Splashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //hide action bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, CreateAccount::class.java))
            finish()
        },3000)
    }
}