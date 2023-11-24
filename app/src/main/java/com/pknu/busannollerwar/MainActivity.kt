package com.pknu.busannollerwar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.pknu.busannollerwar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavigationView()
    }

    private fun setBottomNavigationView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main_fragmentContainverView) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bnvMainBottomNaviView, navController)

        setBottomNavigationVisiblity()
    }

    private fun setBottomNavigationVisiblity() {
        val hideBottomNavigationFragments = mutableListOf<Int>()

        val typedArray = resources.obtainTypedArray(R.array.hide_bottomNavigation_fragments)

        for (index in 0..typedArray.length()) {
            hideBottomNavigationFragments.add(typedArray.getResourceId(index, 0))
        }

        typedArray.recycle()

        navController.addOnDestinationChangedListener { _, destination, _ ->

            binding.bnvMainBottomNaviView.isVisible =
                (destination.id !in hideBottomNavigationFragments)
        }
    }
}