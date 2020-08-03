package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.network.dataagents

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.GenresVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.PersonVO

interface MovieDataAgent {
    fun getAllMovies(
        apiKey : String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getGenres(
        apiKey: String,
        onSuccess: (List<GenresVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getAllPerson(
        apiKey: String,
        onSuccess: (List<PersonVO>) -> Unit,
        onFailure: (String) -> Unit
    )
}