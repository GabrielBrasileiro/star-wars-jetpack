package com.universodoandroid.starwarsjetpack.modules.planets

import android.os.Bundle
import android.view.View
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.FragmentPlanetsBinding
import com.universodoandroid.starwarsjetpack.ui.fragment.BindingFragment

class PlanetsFragment : BindingFragment<FragmentPlanetsBinding>(R.layout.fragment_planets) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.handler = this
    }
}