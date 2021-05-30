package com.bangkit.semarangcoolab.health_mate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bangkit.semarangcoolab.health_mate.databinding.ActivityMainBinding
import com.bangkit.semarangcoolab.health_mate.ui.dashboard.DashboardFragment
import com.bangkit.semarangcoolab.health_mate.ui.home.HomeFragment
import com.bangkit.semarangcoolab.health_mate.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateFragment(HomeFragment())
        viewModel.getFragment().observe(this, { fragment ->
            when (fragment) {
                "favorite" -> navigateFragment(DashboardFragment())
                "bookmark" -> navigateFragment(DashboardFragment())
                "about" -> navigateFragment(NotificationsFragment())
                else -> navigateFragment(HomeFragment())
            }
            Log.d("onCreate", fragment)
        })

        binding.bottomNavigation.setNavigationChangeListener { _, position ->
            when (position) {
                0 -> {
                    viewModel.setFragment("home")
                    navigateFragment(HomeFragment())
                }
                1 -> {
                    viewModel.setFragment("Dashboard")
                    navigateFragment(DashboardFragment())
                }
                2 -> {
                    viewModel.setFragment("Bookmark")
                    navigateFragment(DashboardFragment())
                }
                3 -> {
                    viewModel.setFragment("Notifications")
                    navigateFragment(NotificationsFragment())
                }
            }
        }

    }

    private fun navigateFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.host_frame, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }
}