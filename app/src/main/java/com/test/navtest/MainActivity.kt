package com.test.navtest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navigation, navController)
        navController.addOnDestinationChangedListener { ctrl, destination, arguments ->
            when(destination.id) {
                R.id.navigation_dashboard -> setNavBarVisible(true)
                R.id.navigation_home -> setNavBarVisible(true)
                R.id.navigation_notifications -> setNavBarVisible(true)
                else -> setNavBarVisible(false)
            }

        }
    }

    private fun setNavBarVisible(visible: Boolean) {
        val state = if (visible) View.VISIBLE else View.GONE
        navigation.visibility = state
    }


}
