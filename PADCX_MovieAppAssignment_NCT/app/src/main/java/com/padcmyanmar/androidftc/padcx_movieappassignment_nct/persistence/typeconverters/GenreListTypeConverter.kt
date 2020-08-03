package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreListTypeConverter {
    @TypeConverter
    fun toString(genreList:ArrayList<Int>) : String {
        return Gson().toJson(genreList)
    }
    @TypeConverter
    fun toGenreList(genreListJsonStr:String):ArrayList<Int> {
        val genreListType = object : TypeToken<ArrayList<Int>>() {}.type
        return Gson().fromJson(genreListJsonStr,genreListType)
    }
}