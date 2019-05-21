package com.universodoandroid.starwarsjetpack.modules.personDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.universodoandroid.presentation.ViewState
import com.universodoandroid.presentation.dto.PersonDto
import com.universodoandroid.presentation.factory.PersonDetailsViewModelFactory
import com.universodoandroid.presentation.models.PeopleListViewModel
import com.universodoandroid.presentation.models.PersonDetailsViewModel
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.constants.Constants
import com.universodoandroid.starwarsjetpack.databinding.FragmentPersonDetailsBinding
import com.universodoandroid.starwarsjetpack.modules.BaseFragment

class PersonDetailsFragment : BaseFragment() {

    private val viewModel: PersonDetailsViewModel by lazy {
        ViewModelProviders.of(
            this, PersonDetailsViewModelFactory(application = requireActivity().application)
        ).get(PersonDetailsViewModel::class.java)
    }

    private var binding: FragmentPersonDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_details, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(this, Observer { viewState ->
            when (viewState.status) {
                ViewState.Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                ViewState.Status.SUCCESS -> {
                    binding?.progressBar?.visibility = View.GONE
                    binding?.person = viewState.data
                }
                ViewState.Status.ERROR -> showError(viewState.error)
            }
        })

        val personDto = arguments?.getSerializable(Constants.PERSON_DTO) as? PersonDto
        personDto?.let {
            viewModel.loadPerson(it.id)
        }
    }

    private fun showError(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

}