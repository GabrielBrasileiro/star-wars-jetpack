package com.universodoandroid.starwarsjetpack.modules.people

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.constants.Constants
import com.universodoandroid.starwarsjetpack.databinding.FragmentPeopleBinding
import com.universodoandroid.starwarsjetpack.extensions.addObserver
import com.universodoandroid.starwarsjetpack.extensions.defaultNumberOfColumns
import com.universodoandroid.starwarsjetpack.extensions.show
import com.universodoandroid.starwarsjetpack.presentation.extensions.onEvent
import com.universodoandroid.starwarsjetpack.presentation.extensions.onStateChanged
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.PeopleEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.PeopleListViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.universodoandroid.starwarsjetpack.ui.fragment.BindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeopleFragment : BindingFragment<FragmentPeopleBinding>(R.layout.fragment_people) {

    private val viewModel by viewModel<PeopleListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserver()
        setupEvent()
        setupState()
    }

    private fun setupObserver() {
        addObserver(viewModel)
    }

    private fun setupEvent() {
        onEvent(viewModel) { event ->
            when (event) {
                is PeopleEvent.ShowLoading -> showLoader(true)
                is PeopleEvent.HideLoading -> showLoader(false)
                is PeopleEvent.ShowError -> showError(event.error)
            }
        }
    }

    private fun setupState() {
        onStateChanged(viewModel) {
            showPeople(it.people)
        }
    }

    private fun showPeople(people: List<PersonPresentation>) {
        setupRecyclerView(people)
    }

    private fun setupRecyclerView(people: List<PersonPresentation>) {
        binding.peopleRecyclerView.run {
            layoutManager = GridLayoutManager(requireContext(), resources.defaultNumberOfColumns())
            adapter = PeopleAdapter(people, ::personDetails)
        }
    }

    private fun showError(message: String?) {
        binding.errorMessage.visibility = View.VISIBLE
        println("Error: $message")
    }

    private fun personDetails(personPresentation: PersonPresentation) {
        val args = Bundle().apply { putSerializable(Constants.PERSON_DTO, personPresentation) }
        navController.navigate(R.id.people_navigation_to_person_details, args)
    }

    private fun showLoader(show: Boolean) {
        binding.progressBar.show(show)
    }
}
