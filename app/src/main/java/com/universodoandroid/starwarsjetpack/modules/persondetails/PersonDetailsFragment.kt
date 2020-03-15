package com.universodoandroid.starwarsjetpack.modules.persondetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.constants.Constants
import com.universodoandroid.starwarsjetpack.databinding.FragmentPersonDetailsBinding
import com.universodoandroid.starwarsjetpack.extensions.showToast
import com.universodoandroid.starwarsjetpack.presentation.extensions.onEvent
import com.universodoandroid.starwarsjetpack.presentation.navigation.model.NavigationViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDetailsPresentation
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDto
import com.universodoandroid.starwarsjetpack.presentation.people.models.person.PersonDetailsViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.models.person.PersonEvent
import com.universodoandroid.starwarsjetpack.ui.BindingFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonDetailsFragment :
    BindingFragment<FragmentPersonDetailsBinding>(R.layout.fragment_person_details) {

    private val navigation by sharedViewModel<NavigationViewModel>()
    private val viewModel by viewModel<PersonDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        showNavBar(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBindingObserver()
        initPersonObserver()
        loadPerson()
    }

    private fun setupBindingObserver() {
        binding.lifecycleOwner = this
    }

    private fun initPersonObserver() {
        onEvent(viewModel) { event ->
            when (event) {
                is PersonEvent.ShowUser -> loadUser(event.user)
                is PersonEvent.ShowError -> showError(event.error)
            }
        }
    }

    private fun loadUser(personDetails: PersonDetailsPresentation) {
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

    override fun onDestroyView() {
        showNavBar(true)
        super.onDestroyView()
    }

    private fun showNavBar(show: Boolean) {
        if (show) navigation.showNavigationBar()
        else navigation.hideNavigationBar()
    }

    private fun loadPerson() {
        val personDto = arguments?.getSerializable(Constants.PERSON_DTO) as? PersonDto
        personDto?.run { viewModel.loadPerson(id) }
    }

    private fun showError(error: String) {
        requireContext().showToast(error)
    }

}