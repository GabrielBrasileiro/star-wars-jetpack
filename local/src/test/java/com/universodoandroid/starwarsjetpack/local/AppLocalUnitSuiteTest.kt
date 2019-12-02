package com.universodoandroid.starwarsjetpack.local

import com.universodoandroid.starwarsjetpack.local.people.PersonEntitySuiteTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PersonEntitySuiteTest::class
)
class AppLocalUnitSuiteTest