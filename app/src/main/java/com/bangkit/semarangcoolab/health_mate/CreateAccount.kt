package com.bangkit.semarangcoolab.health_mate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }

    fun gotoLogIn(view: View) {
        val moveIntent = Intent(this, LogIn::class.java)
        startActivity(moveIntent)
    }
}