package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models

import android.content.Context
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.network.MovieApi
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.db.MovieDB
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mMovieApi : MovieApi
    protected lateinit var mTheDB : MovieDB

    init {

        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mMovieApi = retrofit.create(MovieApi::class.java)
    }
    fun initDatabase(context:Context) {
        mTheDB = MovieDB.getDbInstance(context)
    }

}