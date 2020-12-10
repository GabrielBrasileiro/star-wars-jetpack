package com.universodoandroid.starwarsjetpack.main

import android.app.Activity
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.universodoandroid.starwarsjetpack.aliases.IntentParams
import com.universodoandroid.starwarsjetpack.main.utils.DataFactory
import com.universodoandroid.starwarsjetpack.main.utils.RepositoryMock
import io.reactivex.Single
import org.junit.After
import org.junit.Test
import org.koin.core.context.stopKoin

class MainActivityTest {

    private val expectedFirstName = "Lucas"
    private val expectedSecondName = "Gabriel"

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
        launchActivity<MainActivity>()

        // Then
        Espresso.onView(withText(expectedFirstName)).check(matches(isDisplayed()))
        Espresso.onView(withText(expectedSecondName)).check(matches(isDisplayed()))
    }

    private inline fun <reified A : Activity> launchActivity(
        params: IntentParams = {}
    ): ActivityScenario<A>? {
        val intent = Intent(ApplicationProvider.getApplicationContext(), A::class.java)
        intent.apply(params)

        return ActivityScenario.launch(intent)
    }
}
