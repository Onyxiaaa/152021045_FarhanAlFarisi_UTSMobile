package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class register : AppCompatActivity() {
    lateinit var loginbtn: TextView
    lateinit var regisbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        button()
    }
    private fun button() {
        loginbtn = findViewById(R.id.logintext)
        regisbtn = findViewById(R.id.btn_register)
        loginbtn.setOnClickListener {
            val pindah = Intent(this, login::class.java)
            startActivity(pindah)
        }
        regisbtn.setOnClickListener {
            val pindah = Intent(this, login::class.java)
            startActivity(pindah)
        }
    }
}
