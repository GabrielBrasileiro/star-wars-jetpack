package com.universodoandroid.starwarsjetpack.modules.persondetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.constants.Constants
import com.universodoandroid.starwarsjetpack.databinding.FragmentPersonDetailsBinding
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsDto
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDto
import com.universodoandroid.starwarsjetpack.presentation.people.models.person.PersonDetailsViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.models.person.PersonState
import com.universodoandroid.starwarsjetpack.ui.BindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonDetailsFragment : BindingFragment<FragmentPersonDetailsBinding>() {

    override fun getLayoutResId(): Int = R.layout.fragment_person_details

    private val viewModel by viewModel<PersonDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLifecycleObserver()
        initPersonObserver()
        loadPerson()
    }

    private fun setupLifecycleObserver() {
        binding.lifecycleOwner = this
    }

    private fun initPersonObserver() {
        viewModel.getState().observe(this, Observer { state ->
            when (state) {
                is PersonState.ShowUser -> loadUser(state.user)
                is PersonState.ShowError -> showError(state.error)
            }
        })
    }

    private fun loadUser(personDetails: PersonDetailsDto) {
        binding.run {
            person = personDetails
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_star_wars_yellow_logo
                )
            )
        }
    }

    private fun loadPerson() {
        val personDto = arguments?.getSerializable(Constants.PERSON_DTO) as? PersonDto
        personDto?.let { viewModel.loadPerson(it.id) }
    }

    private fun showError(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

}