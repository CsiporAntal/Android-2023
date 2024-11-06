package com.tasty.recipesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.ActivityMainBinding
import com.tasty.recipesapp.ui.home.HomeFragment
import com.tasty.recipesapp.ui.profile.ProfileFragment
import com.tasty.recipesapp.ui.recipe.RecipesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Initialize fragments
    private val homeFragment = HomeFragment()
    private val recipesFragment = RecipesFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("MainActivity", "onCreate")

        // Set default fragment
        replaceFragment(homeFragment)

        // Set up BottomNavigationView listener using the new method
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    replaceFragment(homeFragment)
                    true
                }
                R.id.recipesFragment -> {
                    replaceFragment(recipesFragment)
                    true
                }
                R.id.profileFragment -> {
                    replaceFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    // Function to replace fragments
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
