package com.universodoandroid.starwarsjetpack.modules.people

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.universodoandroid.presentation.PeopleViewModelFactory
import com.universodoandroid.presentation.ViewState
import com.universodoandroid.presentation.dto.PersonDto
import com.universodoandroid.presentation.models.PeopleListViewModel
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.FragmentPeopleBinding

class PeopleFragment : Fragment() {

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
                adapter = PeopleAdapter(it) {
                    Toast.makeText(context, "ClickOn: ${it.name}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showError(message: String?) {
        binding?.errorMessage?.visibility = View.VISIBLE
        binding?.progressBar?.visibility  = View.GONE

        println("Error: $message")
    }

}