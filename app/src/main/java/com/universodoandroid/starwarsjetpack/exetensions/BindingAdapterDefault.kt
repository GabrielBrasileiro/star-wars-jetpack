package com.universodoandroid.starwarsjetpack.exetensions

import android.view.View
import android.view.View.*
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}
