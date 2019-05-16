package com.universodoandroid.starwarsjetpack.modules.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.FragmentPeopleBinding

class PeopleFragment : Fragment() {

    private var binding: FragmentPeopleBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_people, container, false)
        binding?.handler = this



        return binding?.root
    }

}