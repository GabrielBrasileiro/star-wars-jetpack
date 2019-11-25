package com.universodoandroid.starwarsjetpack

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.navigation_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val isDefaultView = defaultDestinationSelected(
                destination.id,
                R.id.navigation_people,
                R.id.navigation_planets
            )

            if (isDefaultView) {
                navigation.visibility = View.VISIBLE
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            } else {
                navigation.visibility = View.GONE
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    private fun defaultDestinationSelected(id: Int, vararg views: Int): Boolean {
        views.forEach {
            if (id == it) return true
        }

        return false
    }

}
