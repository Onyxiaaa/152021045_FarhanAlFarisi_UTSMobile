package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.uts.fragments.FBMI
import com.example.uts.fragments.FCalculator
import com.example.uts.fragments.FConversion
import com.example.uts.fragments.FGraph
import com.example.uts.fragments.FMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btn1 = findViewById<Button>(R.id.btn_1)
//        btn1.setOnClickListener {
//            val builderDialog = AlertDialog.Builder(this)
//
//            builderDialog.setTitle("User Approval")
//            builderDialog.setMessage("Apakah User akan di approve?")
//
//            builderDialog.setPositiveButton("Gasken", DialogInterface.OnClickListener { dialog, which ->
//                Toast.makeText(this, "Gaskeeeeen", Toast.LENGTH_LONG).show()
//            })
//            builderDialog.setNegativeButton("Gagalken", DialogInterface.OnClickListener { dialog, which ->
//                Toast.makeText(this, "Gagalkeunnnn", Toast.LENGTH_LONG).show()
//            })
//            builderDialog.setNeutralButton("Netral", DialogInterface.OnClickListener { dialog, which ->
//                Toast.makeText(this, "Netral Cuy", Toast.LENGTH_LONG).show()
//            })
//
//            builderDialog.show() }
//
        var bottomnavmenu = findViewById<BottomNavigationView>(R.id.bottom_nav)
        loadFragment(FMenu())
        bottomnavmenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bot_menu_home ->{
                    loadFragment(FMenu())
                    true
                }
                R.id.bot_menu_calculator ->{
                    loadFragment(FCalculator())
                    true
                }
                R.id.bot_menu_conversion ->{
                    loadFragment(FConversion())
                    true
                }
                R.id.bot_menu_graph ->{
                    loadFragment(FGraph())
                    true
                }
                R.id.bot_menu_bmi ->{
                    loadFragment(FBMI())
                    true
                }

                else -> {
                    false
                }

            }
        }
    }

    fun loadFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }

    }
}