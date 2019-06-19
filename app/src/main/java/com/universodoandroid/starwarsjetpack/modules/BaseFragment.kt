package com.universodoandroid.starwarsjetpack.modules

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.universodoandroid.starwarsjetpack.R

open class BaseFragment : Fragment() {

    val navController: NavController
        get() = Navigation.findNavController(requireActivity(), R.id.navigation_host_fragment)

}