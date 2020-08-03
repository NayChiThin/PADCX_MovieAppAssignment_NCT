package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO

fun getDummyMovies() : List<MovieVO> {
    val movieOne = MovieVO()
    movieOne.id = 1
    movieOne.title = "Movie One"
    movieOne.originalTitle = "Original Title one"
    movieOne.genres = getDummyGenres()
    val movieTwo = MovieVO()
    movieTwo.id = 2
    movieTwo.title = "Movie Two"
    movieTwo.originalTitle = "Original Title Two"
    movieTwo.genres = getDummyGenres()

    return arrayListOf(movieOne,movieTwo)
}