package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.PersonVO

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getAllPerson() : LiveData<List<PersonVO>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPerson(personList:List<PersonVO>)
}