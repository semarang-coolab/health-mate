package com.bangkit.semarangcoolab.health_mate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
    }

    fun logIn(view: View) {
        val moveIntent = Intent(this, MainActivity::class.java)
        startActivity(moveIntent)
    }
}