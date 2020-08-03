package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE isPopular=1")
    fun getPopularMovies() : LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies WHERE isUpcoming=1")
    fun getUpcomingMovies() : LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies")
    fun getGenresMovies() : LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies WHERE isNowPlaying=1")
    fun getNowPlayingMovies() : LiveData<List<MovieVO>>

    @Query("SELECT * FROM movies WHERE id = :notedId")
    fun getMovieById(notedId:Int) : LiveData<MovieVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovies(movies:List<MovieVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie:MovieVO)

}