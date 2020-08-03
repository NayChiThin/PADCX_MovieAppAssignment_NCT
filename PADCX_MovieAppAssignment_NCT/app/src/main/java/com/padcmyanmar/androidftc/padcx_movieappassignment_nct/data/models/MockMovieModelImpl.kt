package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.GenresVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.PersonVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoDetailVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy.getDummyGenres
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy.getDummyMovies
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy.getDummyPerson
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy.getDummyVideos

object MockMovieModelImpl : MovieModel{
    override fun getPopularMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies())
        return liveData
    }

    override fun getAllMoviesFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getMovieById(movieId: Int): LiveData<MovieVO> {
        val liveData = MutableLiveData<MovieVO>()
        liveData.postValue(getDummyMovies().first{
            it.id == movieId
        })
        return liveData
    }

    override fun getGenres(onError: (String) -> Unit): LiveData<List<GenresVO>> {
        val liveData = MutableLiveData<List<GenresVO>>()
        liveData.postValue(getDummyGenres())
        return liveData
    }

    override fun getPersonList(onError: (String) -> Unit): LiveData<List<PersonVO>> {
        val liveData = MutableLiveData<List<PersonVO>>()
        liveData.postValue(getDummyPerson())
        return liveData
    }

    override fun getMoviesByGenre(genre: Int): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies().filter {
            it.genreIds.contains(genre)
        })
        return liveData
    }

    override fun getNowPlayingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies())
        return liveData
    }

    override fun getUpcomingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies())
        return liveData
    }

    override fun getMovieVideosById(
        movieId: Int,
        onSuccess: (VideoDetailVO) -> Unit,
        onError: (String) -> Unit
    ) {
        val liveDetailVO = getDummyVideos().first()
        if(liveDetailVO.id == movieId) {
            onSuccess(liveDetailVO)
        }
    }
}