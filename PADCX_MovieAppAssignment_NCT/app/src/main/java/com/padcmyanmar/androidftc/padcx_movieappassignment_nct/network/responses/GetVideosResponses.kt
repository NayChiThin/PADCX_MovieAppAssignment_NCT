package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoDetailVO

class GetVideosResponses(
    @SerializedName("id") val id : Int = 0,
    @SerializedName("results") val results : ArrayList<VideoDetailVO>? = null
) {
    fun isResponseOk() = (results != null)
}