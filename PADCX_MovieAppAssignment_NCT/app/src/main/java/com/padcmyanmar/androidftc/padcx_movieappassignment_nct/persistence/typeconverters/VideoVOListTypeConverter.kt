package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoDetailVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoVO

class VideoVOListTypeConverter {
    @TypeConverter
    fun toString(videoVOList:ArrayList<VideoVO>) : String {
        return Gson().toJson(videoVOList)
    }
    @TypeConverter
    fun toVideoVOList(videoListJsonString:String): ArrayList<VideoVO> {
        val videoListType = object : TypeToken<ArrayList<VideoVO>>(){}.type
        return Gson().fromJson(videoListJsonString,videoListType)
    }
}