package com.megganbz.puppyadoption

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

open class BaseFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {

    internal val navController: NavController by lazy {
        findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        if (activity !is BaseActivity) return

        when (this) {
            is HomeFragment -> (activity as BaseActivity).showBottomNavigation()
            else -> hideBottomNavigation()
        }
    }

    private fun hideBottomNavigation() {
        (activity as? BaseActivity)?.hideBottomNavigation()
    }
}