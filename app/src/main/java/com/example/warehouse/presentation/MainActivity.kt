package com.example.warehouse.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.warehouse.R
import com.example.warehouse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.content, HomeFragment()).commit()
        binding.bottomNav.selectedItemId = R.id.homeItemBottomNav
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.addPersonBottomNav -> bottomNavigation(EmployeeFragment())
                R.id.searchItemBottomNav -> bottomNavigation(SearchFragment())
                R.id.homeItemBottomNav -> bottomNavigation(HomeFragment())
                R.id.historyItemBottomNav -> bottomNavigation(HistoryFragment())
                R.id.storeItemBottomNav -> bottomNavigation(StoreFragment())
            }

            return@setOnItemSelectedListener true

        }

    }

    private fun bottomNavigation(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.content, fragment).commit()

    }
}