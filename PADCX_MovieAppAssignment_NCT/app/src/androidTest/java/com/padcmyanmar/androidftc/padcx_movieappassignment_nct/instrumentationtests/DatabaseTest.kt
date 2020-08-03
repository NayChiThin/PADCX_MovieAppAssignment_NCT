package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.*
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.daos.GenresDao
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.daos.MovieDao
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.daos.PersonDao
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.daos.VideoDao
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.persistence.db.MovieDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {
    private lateinit var movieDao : MovieDao
    private lateinit var personDao : PersonDao
    private lateinit var videoDao : VideoDao
    private lateinit var genresDao : GenresDao
    private lateinit var db : MovieDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,MovieDB::class.java
        ).build()
        movieDao = db.movieDao()
        personDao = db.personDao()
        videoDao = db.videoDao()
        genresDao = db.genresDao()
    }
    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest() {
        // insert movie
        val movieOne = MovieVO()
        movieOne.id = 33
        movieOne.title = "Sample One Movie"
        movieOne.overview = "Drama and such"
        movieDao.insertMovie(movieOne)
        assert(movieDao.getMovieById(movieOne.id).value?.id == movieOne.id)
        // insert person
        val personOne = PersonVO()
        personOne.name = "Name One"
        personOne.id = 31
        personOne.profilePath = ""
        val personTwo = PersonVO()
        personOne.name = "Name Two"
        personOne.id = 98
        personOne.profilePath = ""
        personDao.insertAllPerson(arrayListOf(personOne,personTwo))
        assert(personDao.getAllPerson().value?.first()?.id == personOne.id)
        // insert video
        val videoOne = VideoDetailVO()
        videoOne.id = 101
        videoOne.results.add(VideoVO("fjcaewif","jEFeiCw82","Video One"))
        videoDao.insertVideo(videoOne)
        assert(videoDao.getVideoById(videoOne.id).value?.id == videoOne.id)
        // insert genres
        val genresOne = GenresVO()
        genresOne.name = "Horror"
        genresOne.id = 328
        val genresTwo = GenresVO()
        genresTwo.name = "Family"
        genresTwo.id = 181
        genresDao.insertGenres(arrayListOf(genresOne,genresTwo))
        assert(genresDao.getGenres().value?.first()?.id == genresOne.id)
    }
}