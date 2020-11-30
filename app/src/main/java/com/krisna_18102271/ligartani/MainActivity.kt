package com.krisna_18102271.ligartani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Main Activity", "onCreate")

        bottom_navigation.setOnNavigationItemSelectedListener(onBottomNavListener)
        bottom_navigation.getOrCreateBadge(R.id.item_bag_shopping).apply {
            number = 5
            isVisible = true
            backgroundColor = resources.getColor(R.color.ColorPrimary)
        }
        var fr = supportFragmentManager.beginTransaction()
        fr.add(R.id.fl_fragment, HomeFragment())
        fr.commit()
    }
    override fun onPause() {
        super.onPause()

        var fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.fl_fragment, HomeFragment())
        fr.commit()
    }

    private val onBottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener { i ->
        var selectedFr: Fragment = HomeFragment()

        when(i.itemId) {
            R.id.item_home -> {
                selectedFr = HomeFragment()
            }
            R.id.item_search -> {
                selectedFr = SearchFragment()
            }

            R.id.item_bag_shopping -> {
                selectedFr = ShoppingBagFragment()
                bottom_navigation.getOrCreateBadge(R.id.item_bag_shopping).apply {
                    number = 0
                    isVisible = false
                }
            }

            R.id.item_favorite -> {
                selectedFr = FavoriteFragment()
            }

            R.id.item_account -> {
                selectedFr = AccountFragment()
            }
        }

        var fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.fl_fragment, selectedFr)
        fr.commit()
        true
    }

}