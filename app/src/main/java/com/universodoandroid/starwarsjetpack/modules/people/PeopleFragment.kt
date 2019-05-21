package com.universodoandroid.starwarsjetpack.modules.people

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.universodoandroid.presentation.factory.PeopleViewModelFactory
import com.universodoandroid.presentation.ViewState
import com.universodoandroid.presentation.dto.PersonDto
import com.universodoandroid.presentation.models.PeopleListViewModel
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.constants.Constants
import com.universodoandroid.starwarsjetpack.databinding.FragmentPeopleBinding
import com.universodoandroid.starwarsjetpack.modules.BaseFragment

class PeopleFragment : BaseFragment() {

    private val viewModel: PeopleListViewModel by lazy {
        ViewModelProviders.of(
            this, PeopleViewModelFactory(application = requireActivity().application)
        ).get(PeopleListViewModel::class.java)
    }

    private var binding: FragmentPeopleBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_people, container, false)
        binding?.handler = this

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(this, Observer { viewState ->
            when (viewState.status) {
                ViewState.Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                ViewState.Status.SUCCESS -> showList(people = viewState.data)
                ViewState.Status.ERROR   -> showError(message = viewState.error)
            }
        })

        lifecycle.addObserver(viewModel)
    }

    private fun showList(people: List<PersonDto>?) {
        binding?.progressBar?.visibility = View.GONE

        people?.let {
            val columns =
                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 1
                else 2

            binding?.peopleRecyclerView?.run {
                layoutManager = GridLayoutManager(requireContext(), columns)
                adapter = PeopleAdapter(it) { personDto ->
                    personDetails(personDto)
                }
            }
        }
    }

    private fun showError(message: String?) {
        binding?.errorMessage?.visibility = View.VISIBLE
        binding?.progressBar?.visibility  = View.GONE

        println("Error: $message")
    }

    private fun personDetails(personDto: PersonDto) {
        val args = Bundle().apply {
            putSerializable(Constants.PERSON_DTO, personDto)
        }
        navController.navigate(R.id.people_navigation_to_person_details, args)
    }

}