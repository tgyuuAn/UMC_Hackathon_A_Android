package com.pknu.busannollerwar

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.pknu.busannollerwar.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setBottomNavigationView()
    }

    private fun setBottomNavigationView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main_fragmentContainverView) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bnvMainBottomNaviView, navController)
        binding.bnvMainBottomNaviView.itemIconTintList = null
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