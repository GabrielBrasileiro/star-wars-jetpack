package com.universodoandroid.starwarsjetpack.modules.people

import android.content.Context
import coil.ImageLoader
import coil.api.load
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.ItemPersonBinding
import com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model.PersonPresentation
import com.universodoandroid.starwarsjetpack.ui.adapter.BindingAdapter

class PeopleAdapter(
    private val people: List<PersonPresentation>,
    private val onClick: (PersonPresentation) -> Unit
) : BindingAdapter<ItemPersonBinding>(R.layout.item_person) {

    override fun onBindViewHolder(binding: ItemPersonBinding, position: Int) = binding.run {
        val currentPerson = people[position]
        person = currentPerson

        imageView.load(currentPerson.imageUrl, buildLoader(root.context))

        executePendingBindings()

        root.setOnClickListener { onClick(currentPerson) }
    }

    private fun buildLoader(context: Context) = ImageLoader(context) {
        availableMemoryPercentage(0.5)
        bitmapPoolPercentage(0.5)
        crossfade(true)
    }

    override fun getItemCount(): Int = people.size

}