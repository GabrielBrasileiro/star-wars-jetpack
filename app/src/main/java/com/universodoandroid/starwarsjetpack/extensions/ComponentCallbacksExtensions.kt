package com.universodoandroid.starwarsjetpack.extensions

import android.content.ComponentCallbacks
import com.universodoandroid.starwarsjetpack.shared.extensions.identifier
import com.universodoandroid.starwarsjetpack.shared.mapper.Mapper
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

inline fun <reified I, reified O> ComponentCallbacks.injectMapper(): Lazy<Mapper<I, O>> {
    return inject(named(identifier<I, O>()))
}