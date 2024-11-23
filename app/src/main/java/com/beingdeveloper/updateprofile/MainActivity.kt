package com.beingdeveloper.updateprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.beingdeveloper.updateprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup the toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false) // Initially, no back button

        // Load the HomeFragment initially
        if (savedInstanceState == null) {
            navigateToFragment(HomeFragment(), false)
        }

        // Toolbar back button functionality
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Add a fragment listener to monitor fragment changes
        supportFragmentManager.addOnBackStackChangedListener {
            updateBackButtonVisibility()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    // Navigate to a new fragment
    fun navigateToFragment(fragment: Fragment, showBackButton: Boolean) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
            if (showBackButton) {
                addToBackStack(null)
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(showBackButton)
    }

    // Update the back button visibility based on the current fragment
    private fun updateBackButtonVisibility() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment is HomeFragment) {
            supportActionBar?.setDisplayHomeAsUpEnabled(false) // Hide back button
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show back button
        }
    }
}
