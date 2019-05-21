package com.universodoandroid.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universodoandroid.local.entity.PersonEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(personEntity: PersonEntity): Completable

    @Query("SELECT * FROM personEntity")
    fun getPeople(): Flowable<List<PersonEntity>>

}