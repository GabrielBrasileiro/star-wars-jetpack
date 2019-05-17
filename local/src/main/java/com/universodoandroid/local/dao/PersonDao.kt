package com.universodoandroid.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universodoandroid.local.entity.Person
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(person: Person): Completable

    @Query("SELECT * FROM person")
    fun getPeople(): Flowable<List<Person>>

}