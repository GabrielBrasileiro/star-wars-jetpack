package com.universodoandroid.starwarsjetpack.modules.planets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.FragmentPlanetsBinding
import com.universodoandroid.starwarsjetpack.ui.BindingFragment

class PlanetsFragment : BindingFragment<FragmentPlanetsBinding>() {

    override fun getLayoutResId() = R.layout.fragment_planets

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.handler = this
    }

}