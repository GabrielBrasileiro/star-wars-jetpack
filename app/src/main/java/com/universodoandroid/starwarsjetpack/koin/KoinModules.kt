package com.universodoandroid.starwarsjetpack.koin

import com.universodoandroid.starwarsjetpack.data.di.getRepositoryModules
import com.universodoandroid.starwarsjetpack.domain.di.getUseCaseModules
import com.universodoandroid.starwarsjetpack.local.di.getDatabaseModules
import com.universodoandroid.starwarsjetpack.main.router.di.getBottomNavigationModules
import com.universodoandroid.starwarsjetpack.presentation.di.getViewModelsModules
import com.universodoandroid.starwarsjetpack.remote.di.getRemoteModules
import org.koin.core.module.Module

class KoinModules {

    fun getModules(): List<Module> {
        return listOfModules(
            getBottomNavigationModules(),
            getRemoteModules(),
            getDatabaseModules(),
            getRepositoryModules(),
            getUseCaseModules(),
            getViewModelsModules(),
        )
    }

    private fun listOfModules(vararg modules: List<Module>): List<Module> {
        val mappedModules = ArrayList<Module>()
        modules.forEach { mappedModules.addAll(it) }
        return mappedModules
    }
}