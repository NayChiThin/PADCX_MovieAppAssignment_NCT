package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.GenresVO

data class GetGenresResponses(
    @SerializedName("genres") val genres : ArrayList<GenresVO>? = null
) {
    fun isResponseOk() = (genres != null)
}