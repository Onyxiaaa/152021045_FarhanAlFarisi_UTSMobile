package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class login : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var registerbtn: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button()
    }
    private fun button() {
        button1 = findViewById(R.id.login2)
        username = findViewById(R.id.login_username)
        password = findViewById(R.id.login_password)
        registerbtn = findViewById(R.id.register)
        button1.setOnClickListener {
            if(username.text.toString().isBlank() && password.text.toString().isBlank()){
                Toast.makeText(this,"Username and password cannot be empty",Toast.LENGTH_SHORT).show()
            }else if(username.text.toString().equals("ahan") && password.text.toString().equals("ahan")){
                var pindah = Intent(this,MainActivity::class.java)
                var ambil = username.getText().toString()
                pindah.putExtra("textToDisplay", ambil)
                startActivity(pindah)
            }
        }
        registerbtn.setOnClickListener {
            val pindah = Intent(this, register::class.java)
            startActivity(pindah)
        }
    }
}