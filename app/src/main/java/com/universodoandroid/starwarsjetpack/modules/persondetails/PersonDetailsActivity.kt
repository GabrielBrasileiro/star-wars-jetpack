package com.universodoandroid.starwarsjetpack.modules.persondetails

import android.os.Bundle
import com.mvvmredux.ext.onEvent
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.ActivityPersonDetailsBinding
import com.universodoandroid.starwarsjetpack.extensions.showToast
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person.PersonDetailsViewModel
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person.PersonEvent
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.person.model.PersonDetailsPresentation
import com.universodoandroid.starwarsjetpack.ui.activity.BindingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonDetailsActivity : BindingActivity<ActivityPersonDetailsBinding>(
    R.layout.activity_person_details
) {

    private val viewModel by viewModel<PersonDetailsViewModel>()

    private val personId by lazy { intent.getStringExtra(PERSON_ID) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

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
        }
    }

    private fun loadPerson() {
        personId.run { viewModel.loadPerson(personId) }
    }

    private fun showError(error: String) {
        showToast(error)
    }

    companion object {
        const val PERSON_ID = "person_id_key"
    }
}