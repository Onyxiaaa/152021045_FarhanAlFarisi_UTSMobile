package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class home : AppCompatActivity() {
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        button()
    }
    private fun button(){
        back = findViewById(R.id.back_home)
        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}