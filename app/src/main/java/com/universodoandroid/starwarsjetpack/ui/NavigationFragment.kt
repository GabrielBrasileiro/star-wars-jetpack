package com.universodoandroid.starwarsjetpack.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.universodoandroid.starwarsjetpack.R

open class NavigationFragment(
    @LayoutRes protected val layoutResId: Int
) : Fragment(layoutResId) {

    val navController: NavController
        get() = Navigation.findNavController(requireActivity(), R.id.navigation_host_fragment)

}