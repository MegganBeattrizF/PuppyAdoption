package com.megganbz.puppyadoption

import android.os.Bundle
import android.view.Menu
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.megganbz.puppyadoption.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewBinding()
        setupNavController()
        setupBottomNavigation()
    }

    private fun setupNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_fragment_container
        ) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_navigation_menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setupViewBinding() {
        binding = ActivityBaseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun showBottomNavigation() {
        binding.bottomNavigationView.isVisible = true
        binding.bottomNavigationView.animate()
            ?.translationY(0f)
            ?.setInterpolator(AccelerateDecelerateInterpolator())
            ?.start()
    }

    fun hideBottomNavigation() {
        binding.bottomNavigationView.isVisible = false
        binding.bottomNavigationView.animate()
            ?.translationY(binding.bottomNavigationView.height.toFloat())
            ?.setInterpolator(AccelerateDecelerateInterpolator())
            ?.start()
    }
}