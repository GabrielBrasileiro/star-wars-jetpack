package com.universodoandroid.starwarsjetpack.modules.planets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.FragmentPlanetsBinding

class PlanetsFragment : Fragment() {

    var binding: FragmentPlanetsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_planets, container, false)

        return binding?.root
    }

}