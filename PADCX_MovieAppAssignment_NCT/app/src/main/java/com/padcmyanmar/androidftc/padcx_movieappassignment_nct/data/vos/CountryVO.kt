package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "countries")
data class CountryVO(
    @PrimaryKey
    @SerializedName("iso_3166_1") var iso : String = "",
    @SerializedName("name") var name : String = ""
) {
}