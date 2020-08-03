package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.typeconverters.VideoVOListTypeConverter

@Entity(tableName = "videoDetails")
@TypeConverters(VideoVOListTypeConverter::class)
data class VideoDetailVO(
    @PrimaryKey
    @SerializedName("id") var id : Int = 0,
    @SerializedName("results") var results : ArrayList<VideoVO> = arrayListOf()
) {
}