package com.susandangol.softwaricaapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.susandangol.softwaricaapplication.R
import com.susandangol.softwaricaapplication.fragments.AboutFragment
import com.susandangol.softwaricaapplication.fragments.HomeFragment
import com.susandangol.softwaricaapplication.fragments.StudentFragment

class DashboardActivity : AppCompatActivity() {

    private val studentFragment = StudentFragment()
    private val homeFragment = HomeFragment()
    private val aboutFragment = AboutFragment()

    private lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        replaceFragment(homeFragment)

        bottomNav = findViewById(R.id.bottomNav)

        bottomNav.setOnNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.itemHome -> replaceFragment(homeFragment)
                R.id.itemNewStudent -> replaceFragment(studentFragment)
                R.id.itemAbout -> replaceFragment(aboutFragment)

            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.linearContainer, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}