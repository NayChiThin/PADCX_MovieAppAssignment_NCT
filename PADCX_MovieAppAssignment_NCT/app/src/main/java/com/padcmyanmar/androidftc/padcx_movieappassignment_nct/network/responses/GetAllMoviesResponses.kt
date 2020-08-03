package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO

data class GetAllMoviesResponses(
    @SerializedName("page") val page : Int = 0,
    @SerializedName("total_results") val totalResults : Int = 0,
    @SerializedName("total_pages") val totalPages : Int = 0,
    @SerializedName("results") val results : ArrayList<MovieVO>? = null
) {
    fun isResponseOk() = (results != null)
}