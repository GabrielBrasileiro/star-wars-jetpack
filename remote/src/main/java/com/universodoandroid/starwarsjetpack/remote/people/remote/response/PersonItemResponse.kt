package com.universodoandroid.starwarsjetpack.remote.people.remote.response

import com.google.gson.annotations.SerializedName

internal data class PersonItemResponse(

    @SerializedName("birth_year")
    val birthYear: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("edited")
    val edited: String,

    @SerializedName("eye_color")
    val eyeColor: String,

    @SerializedName("films")
    val films: List<String>? = null,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("hair_color")
    val hairColor: String,

    @SerializedName("height")
    val height: String,

    @SerializedName("homeworld")
    val homeworld: String,

    @SerializedName("mass")
    val mass: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("skin_color")
    val skinColor: String,

    @SerializedName("species")
    val species: List<String>? = null,

    @SerializedName("starships")
    val starships: List<String>? = null,

    @SerializedName("url")
    val url: String,

    @SerializedName("vehicles")
    val vehicles: List<String>? = null

)