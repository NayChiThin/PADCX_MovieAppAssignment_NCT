package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.*
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.daos.*

@Database(entities = [MovieVO::class,GenresVO::class,PersonVO::class,VideoDetailVO::class],version = 11,exportSchema = false)
abstract class MovieDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PADCX-MOVIE.DB"
        var dbInstance : MovieDB? = null
        fun getDbInstance(context : Context):MovieDB {
            when(dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context,MovieDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }
    abstract fun movieDao() : MovieDao
    abstract fun genresDao() : GenresDao
    abstract fun personDao() : PersonDao
    abstract fun videoDao() : VideoDao
}