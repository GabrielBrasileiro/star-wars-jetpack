package com.universodoandroid.remote.policy

interface Policy {
    fun withPolicy(police: Case)

    enum class Case {
        REMOTE, LOCAL
    }
}