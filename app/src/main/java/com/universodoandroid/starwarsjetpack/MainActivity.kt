package com.universodoandroid.starwarsjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.universodoandroid.starwarsjetpack.extensions.show
import com.universodoandroid.starwarsjetpack.presentation.extensions.onStateChanged
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val navigation by viewModel<NavigationViewModel>()

    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.navigation_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigationController()
        onNavigationChanged()
    }

    private fun setupNavigationController() {
        navigationView.setupWithNavController(navController)
    }

    private fun onNavigationChanged() {
        onStateChanged(navigation) { showNavigation(it.showNavBar) }
    }

    private fun showNavigation(show: Boolean) {
        if (show) setupNavigation(visibility = true, actionBarEnabled = false)
        else setupNavigation(visibility = false, actionBarEnabled = true)
    }

    private fun setupNavigation(visibility: Boolean, actionBarEnabled: Boolean) {
        navigationView.show(visibility)
        supportActionBar?.setDisplayHomeAsUpEnabled(actionBarEnabled)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
