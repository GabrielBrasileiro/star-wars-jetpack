package com.universodoandroid.starwarsjetpack.remote.people.remote.response

import com.google.gson.annotations.SerializedName


internal data class PeopleResponse(

    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String?,

    @SerializedName("previous")
    val previous: Any,

    @SerializedName("results")
    val results: List<PersonItemResponse>

)