package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class register : AppCompatActivity() {
    lateinit var loginbtn: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        button()
    }
    private fun button() {
        loginbtn = findViewById(R.id.logintext)
        loginbtn.setOnClickListener {
            val pindah = Intent(this, login::class.java)
            startActivity(pindah)
        }
    }
}