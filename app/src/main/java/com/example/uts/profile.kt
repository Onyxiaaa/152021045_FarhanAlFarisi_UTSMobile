package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.uts.fragments.FCalculator

class profile : AppCompatActivity() {
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        button()
        var txt_welcome = findViewById<TextView>(R.id.textView)
        val txtDiterima = intent.getStringExtra("textToDisplay")
        txt_welcome.text = txtDiterima
    }
    private fun button(){
        back = findViewById(R.id.back)
        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}