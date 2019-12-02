package com.universodoandroid.starwarsjetpack.presentation.models.people

import com.universodoandroid.starwarsjetpack.presentation.dto.PersonDto

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