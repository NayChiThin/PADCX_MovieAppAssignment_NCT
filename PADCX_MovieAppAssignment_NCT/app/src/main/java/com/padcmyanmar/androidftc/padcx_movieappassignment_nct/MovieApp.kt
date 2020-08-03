package com.padcmyanmar.androidftc.padcx_movieappassignment_nct

import android.app.Application
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models.MovieModelImpl

class MovieApp:Application() {
    override fun onCreate() {
        super.onCreate()

        MovieModelImpl.initDatabase(applicationContext)
    }
}