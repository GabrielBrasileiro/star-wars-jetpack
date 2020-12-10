package com.universodoandroid.starwarsjetpack.main

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import com.universodoandroid.starwarsjetpack.R
import com.universodoandroid.starwarsjetpack.koin.KoinModules
import com.universodoandroid.starwarsjetpack.main.utils.DataFactory
import com.universodoandroid.starwarsjetpack.main.utils.RepositoryMock
import com.universodoandroid.starwarsjetpack.modules.people.PeopleFragment
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class PeopleFragmentTest {

    private val expectedFirstName = "Lucas"
    private val expectedSecondName = "Gabriel"

    @Before
    fun setup() {
        stopKoin()
        startKoin {
            androidContext(InstrumentationRegistry.getInstrumentation().context)
            modules(KoinModules().getModules())
        }
    }

    @Test
    fun whenEnter_withSuccess_shouldShowCharacters() {
        // Given
        RepositoryMock.setupPeopleResult {
            Single.just(
                listOf(
                    DataFactory.create(expectedFirstName),
                    DataFactory.create(expectedSecondName),
                )
            )
        }

        // When
        launchFragmentInContainer<PeopleFragment>(themeResId = R.style.AppTheme)

        // Then
        Espresso.onView(withText(expectedFirstName)).check(matches(isDisplayed()))
        Espresso.onView(withText(expectedSecondName)).check(matches(isDisplayed()))
    }

    @Test
    fun whenEnter_withError_shouldShowErrorMessage() {
        // Given
        RepositoryMock.setupPeopleResult { Single.error(Throwable("Error to load all characters")) }

        // When
        launchFragmentInContainer<PeopleFragment>(themeResId = R.style.AppTheme)

        // Then
        Espresso.onView(withText("Error to recover people of server"))
            .check(matches(isDisplayed()))
    }
}
