package com.universodoandroid.starwarsjetpack.modules.people

import androidx.annotation.LayoutRes
import com.universodoandroid.presentation.dto.PersonDto
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.ItemPersonBinding
import com.universodoandroid.starwarsjetpack.ui.BindingAdapter

class PeopleAdapter(private val people: List<PersonDto>, private val onClick: (PersonDto) -> Unit) : BindingAdapter<ItemPersonBinding>() {

    @LayoutRes
    override fun getLayoutResId(): Int = R.layout.item_person

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