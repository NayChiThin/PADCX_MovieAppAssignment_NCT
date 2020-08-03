package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.*

interface MainView :BaseView{
    fun displayPopularMovieList(movieList:List<MovieVO>)
    fun displayNowPlayingMovieList(movieList:List<MovieVO>)
    fun setGenresList(genresList:List<GenresVO>)
    fun displayPersonList(personList:List<PersonVO>)
    fun navigateToDetails(movieId:Int)
    fun displayMoviesByGenre(movieList: List<MovieVO>)
    fun displayUpcomingMovieList(movieList: List<MovieVO>)
    fun navigateToPlay(movie:VideoDetailVO)
}