package com.universodoandroid.starwarsjetpack.presentation.people.models.people

import com.universodoandroid.starwarsjetpack.presentation.people.dto.PersonDto
import com.universodoandroid.starwarsjetpack.presentation.utils.ViewState

sealed class PeopleState : ViewState {

    data class ShowData(
        val data: List<PersonDto>
    ) : PeopleState()

    data class ShowError(
        val error: String
    ) : PeopleState()

    object HideLoading : PeopleState()
    object ShowLoading : PeopleState()

}