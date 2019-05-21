package com.universodoandroid.remote.policy

interface Policy<L> {
    fun firstSync(local: L, onComplete: () -> Unit, onError: (Throwable) -> Unit)
    fun update(local: L)
}