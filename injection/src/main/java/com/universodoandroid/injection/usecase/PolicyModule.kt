package com.universodoandroid.injection.usecase

import com.universodoandroid.remote.policy.PeoplePolicy
import org.koin.dsl.module

val policyModule = module {
    factory { PeoplePolicy(get(), get()) }
}