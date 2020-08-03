package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.GenresVO

@Dao
interface GenresDao {
    @Query("SELECT * FROM genres")
    fun getGenres() : LiveData<List<GenresVO>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres(genres:List<GenresVO>)
}