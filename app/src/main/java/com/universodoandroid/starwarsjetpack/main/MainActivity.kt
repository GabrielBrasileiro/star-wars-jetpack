package com.universodoandroid.starwarsjetpack.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.extensions.show
import com.universodoandroid.starwarsjetpack.main.router.MainBottomNavRouter
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val navigationViewModel by viewModel<NavigationViewModel>()
    private val screenSelected: Int? by lazy { navigationViewModel.getCurrentScreen() }

    private val router by inject<MainBottomNavRouter> {
        parametersOf(screenSelected, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigationListener()
        setupFirstScreenIfNeeded()
    }

    private fun setupFirstScreenIfNeeded() {
        val firstScreen = R.id.navigation_people
        navigationView.selectedItemId = screenSelected ?: firstScreen
    }

    private fun setupBottomNavigationListener() {
        navigationView.setOnNavigationItemSelectedListener { router.navigateTo(it.itemId) }
    }

    override fun onDestroy() {
        val currentScreen = navigationView.selectedItemId
        navigationViewModel.selectCurrentScreen(currentScreen)

        super.onDestroy()
    }

}
