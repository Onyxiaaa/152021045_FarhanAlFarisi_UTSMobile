package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class setting : AppCompatActivity() {
    lateinit var buttonsave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        button()
    }
    private fun button() {
        buttonsave = findViewById(R.id.save_setting)
        buttonsave.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}