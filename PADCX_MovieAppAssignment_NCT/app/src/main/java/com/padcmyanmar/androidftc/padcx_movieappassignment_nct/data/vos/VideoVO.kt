package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "videos")
data class VideoVO (
    @PrimaryKey
    @SerializedName("id") var id : String = "",
    @SerializedName("key") var key : String = "",
    @SerializedName("name") var name : String = ""
){

}