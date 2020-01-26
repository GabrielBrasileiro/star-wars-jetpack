package com.universodoandroid.starwarsjetpack.presentation.people.models.people

import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDto

sealed class PeopleState {

    data class ShowData(
        val data: List<PersonDto>
    ) : PeopleState()

    data class ShowError(
        val error: String
    ) : PeopleState()

    object HideLoading : PeopleState()
    object ShowLoading : PeopleState()

}