package com.universodoandroid.starwarsjetpack.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.universodoandroid.starwarsjetpack.local.people.dao.PersonDao
import com.universodoandroid.starwarsjetpack.local.people.database.entity.PersonEntity

@Database(
    entities = [PersonEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    internal abstract fun personDao(): PersonDao

}