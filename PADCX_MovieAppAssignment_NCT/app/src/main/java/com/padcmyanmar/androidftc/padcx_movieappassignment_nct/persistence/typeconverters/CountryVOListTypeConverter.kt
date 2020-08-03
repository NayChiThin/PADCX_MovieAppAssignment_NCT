package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.CountryVO


class CountryVOListTypeConverter {
    @TypeConverter
    fun toString(countryVOList:ArrayList<CountryVO>?) : String {
        countryVOList?.let {
            return Gson().toJson(countryVOList)
        }
        return ""
    }
    @TypeConverter
    fun toCountyVOList(countryVOListJsonString:String):ArrayList<CountryVO> {
        val countryVOListType = object : TypeToken<ArrayList<CountryVO>>(){}.type
        if(!countryVOListJsonString.isEmpty()){
            return Gson().fromJson(countryVOListJsonString,countryVOListType)
        }
        return arrayListOf()
    }
}