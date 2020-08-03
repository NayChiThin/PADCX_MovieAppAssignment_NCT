package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.*

interface MovieModel {
    fun getPopularMovies(onError:(String) -> Unit) : LiveData<List<MovieVO>>
    fun getAllMoviesFromApiAndSaveToDatabase(onSuccess:()->Unit,onError: (String) -> Unit)
    fun getMovieById(movieId:Int) : LiveData<MovieVO>
    fun getGenres(onError: (String) -> Unit) : LiveData<List<GenresVO>>
    fun getPersonList(onError: (String) -> Unit) : LiveData<List<PersonVO>>
    fun getMoviesByGenre(genre:Int) : LiveData<List<MovieVO>>
    fun getNowPlayingMovies(onError: (String) -> Unit):LiveData<List<MovieVO>>
    fun getUpcomingMovies(onError: (String) -> Unit) : LiveData<List<MovieVO>>
    fun getMovieVideosById(movieId: Int,onSuccess: (VideoDetailVO) -> Unit,onError: (String) -> Unit)
}