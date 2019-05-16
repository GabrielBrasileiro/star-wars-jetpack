package com.universodoandroid.starwarsjetpack.modules.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.universodoandroid.remote.remote.InjectionRemoteDataSource
import com.universodoandroid.remote.usecase.people.GetPeople
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.FragmentPeopleBinding

class PeopleFragment : Fragment() {

    private var binding: FragmentPeopleBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_people, container, false)
        binding?.handler = this

        GetPeople(InjectionRemoteDataSource.providePeopleRemoteDataSource()).getPeople({ peopleResponse ->
            Toast.makeText(context, peopleResponse.results[0].name, Toast.LENGTH_LONG).show()
        }) { error ->
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        }

        return binding?.root
    }

}