package com.example.weekfour_ui_viewpager_recyclerview

import Fragments.GiftsFragment
import Fragments.HomeFragment
import Fragments.PeopleFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val peopleFragment = PeopleFragment()
    private val giftsFragment = GiftsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(homeFragment)

        val home = findViewById<BottomNavigationItemView>(R.id.home_navigation)
        home.setOnClickListener {
            replaceFragment(homeFragment)
        }

        val people = findViewById<BottomNavigationItemView>(R.id.peope_navigation)
        people.setOnClickListener {
            replaceFragment(peopleFragment)
        }

        val gifts = findViewById<BottomNavigationItemView>(R.id.gift_navigation)
        gifts.setOnClickListener {
            replaceFragment(giftsFragment)
        }


    }
    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }


}