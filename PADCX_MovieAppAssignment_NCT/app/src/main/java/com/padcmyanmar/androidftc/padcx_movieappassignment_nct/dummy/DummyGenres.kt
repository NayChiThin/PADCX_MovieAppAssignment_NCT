package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.GenresVO

fun getDummyGenres() : ArrayList<GenresVO> {
    val genresOne = GenresVO()
    genresOne.id = 1
    genresOne.name = "Action"
    val genresTwo = GenresVO()
    genresTwo.id = 2
    genresTwo.name = "Adventure"

    return arrayListOf(genresOne,genresTwo)
}