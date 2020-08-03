package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.GenresVO

class GenresVOListTypeConverter {
    @TypeConverter
    fun toString(genresList:ArrayList<GenresVO?>?):String {
        genresList?.let {
            return Gson().toJson(genresList)
        }
        return ""
    }
    @TypeConverter
    fun toGenresVOList(genreListJsonString:String):ArrayList<GenresVO?>? {
        val genreListType = object : TypeToken<ArrayList<GenresVO>>(){}.type
        if(!genreListJsonString.isEmpty()){
            return Gson().fromJson(genreListJsonString,genreListType)
        }
        return arrayListOf()
    }
}