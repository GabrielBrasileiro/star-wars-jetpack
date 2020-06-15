package com.universodoandroid.starwarsjetpack.domain.people.usecase

import com.universodoandroid.starwarsjetpack.domain.people.entities.Person
import com.universodoandroid.starwarsjetpack.domain.people.repository.PeopleRepository
import io.reactivex.Single

class GetPeopleUseCase(private val repository: PeopleRepository) {

    fun getPeople(): Single<List<Person>> {
        return repository.getPeople()
    }
}