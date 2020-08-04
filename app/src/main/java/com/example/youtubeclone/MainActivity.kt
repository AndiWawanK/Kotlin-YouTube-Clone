package com.example.youtubeclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation_bottom.setOnNavigationItemSelectedListener(onBottomNavigationListener)

        var fragmentItem = supportFragmentManager.beginTransaction()
        fragmentItem.add(R.id.fl_fragment, HomeFragment())
        fragmentItem.commit()
    }

    private val onBottomNavigationListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFr: Fragment = HomeFragment()

        when(item.itemId) {
            R.id.btm_home -> selectedFr = HomeFragment()
            R.id.btm_explore -> selectedFr = ExploreFragment()
            R.id.btm_subscriptions -> selectedFr = SubscriptionFragment()
            R.id.btm_account -> selectedFr = AccountFragment()
        }

        var fragmentItem = supportFragmentManager.beginTransaction()
        fragmentItem.replace(R.id.fl_fragment, selectedFr)
        fragmentItem.commit()

        true
    }
}