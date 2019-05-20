package com.universodoandroid.starwarsjetpack.modules.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.universodoandroid.presentation.dto.PersonDto
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.databinding.ItemPersonBinding

class PeopleAdapter(private val people: List<PersonDto>, private val onClick: (PersonDto) -> Unit) :
    RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.run {
            val currentPerson = people[position]
            person = currentPerson

            executePendingBindings()

            root.setOnClickListener { onClick(currentPerson) }
        }
    }

    override fun getItemCount(): Int = people.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ItemPersonBinding>(view)
    }

}