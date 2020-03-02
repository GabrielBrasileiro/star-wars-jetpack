package com.universodoandroid.starwarsjetpack.modules.people

import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.ItemPersonBinding
import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDto
import com.universodoandroid.starwarsjetpack.ui.BindingAdapter

class PeopleAdapter(
    private val people: List<PersonDto>,
    private val onClick: (PersonDto) -> Unit
) : BindingAdapter<ItemPersonBinding>(R.layout.item_person) {

    override fun onBindViewHolder(binding: ItemPersonBinding, position: Int) {
        binding.run {
            val currentPerson = people[position]
            person = currentPerson

            executePendingBindings()

            root.setOnClickListener { onClick(currentPerson) }
        }
    }

    override fun getItemCount(): Int = people.size

}