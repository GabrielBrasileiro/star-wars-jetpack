package com.universodoandroid.starwarsjetpack.presentation.people.viewmodels.people.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonPresentation(
    val id: String,
    val name: String,
    val planet: String,
    val imageUrl: String? = null
) : Parcelable