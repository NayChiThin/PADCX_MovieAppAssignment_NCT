package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.*
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.utils.DUMMY_API_KEY
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieModelImpl : MovieModel,BaseModel() {
    override fun getPopularMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        return mTheDB.movieDao().getPopularMovies()
    }

    @SuppressLint("CheckResult")
    override fun getAllMoviesFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getPopularMovieList(DUMMY_API_KEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                for(i in it.indices) {
                    it[i].isPopular = 1
                }
                mTheDB.movieDao().insertAllMovies(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
        mMovieApi.getGenres(DUMMY_API_KEY)
            .map { it.genres?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.genresDao().insertGenres(it)
            },{
                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
        mMovieApi.getPersonList(DUMMY_API_KEY)
            .map { it.results?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.personDao().insertAllPerson(it)
            },{
                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
        mMovieApi.getUpcomingMovies(DUMMY_API_KEY)
            .map { it.results?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                for(i in it.indices) {
                    it[i].isUpcoming = 1
                }
                mTheDB.movieDao().insertAllMovies(it)
            },{
                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
        mMovieApi.getNowPlayingMovieList(DUMMY_API_KEY)
            .map { it.results?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
//                for(i in it.indices) {
//                    it[i].isNowPlaying = 1
//                }
                val nowPlayingList = it.map {movie ->
                    movie.isNowPlaying = 1
                    return@map movie
                }.toList()
                mTheDB.movieDao().insertAllMovies(nowPlayingList)
            },{
                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    override fun getMovieById(movieId: Int): LiveData<MovieVO> {
        mMovieApi.getMovieDetail(movieId,DUMMY_API_KEY)
            .subscribeOn(Schedulers.io())
            .subscribe({
                mTheDB.movieDao().insertMovie(it)
            },{

            })
        return mTheDB.movieDao().getMovieById(movieId)
    }

    override fun getGenres(onError: (String) -> Unit): LiveData<List<GenresVO>> {
        return mTheDB.genresDao().getGenres()
    }
    override fun getPersonList(onError: (String) -> Unit): LiveData<List<PersonVO>> {
        return mTheDB.personDao().getAllPerson()
    }

    @SuppressLint("CheckResult")
    override fun getMoviesByGenre(genre:Int): LiveData<List<MovieVO>> {
        mMovieApi.getMoviesByGenre(genre, DUMMY_API_KEY)
            .map {
                it.results?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                mTheDB.movieDao().insertAllMovies(it)
            },{

            })
        return mTheDB.movieDao().getGenresMovies()

    }

    override fun getNowPlayingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        return mTheDB.movieDao().getNowPlayingMovies()
    }

    override fun getUpcomingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        return mTheDB.movieDao().getUpcomingMovies()
    }

    @SuppressLint("CheckResult")
    override fun getMovieVideosById(
        movieId: Int,
        onSuccess: (VideoDetailVO) -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getMovieVideoById(movieId, DUMMY_API_KEY)
            .subscribeOn(Schedulers.io())
            .subscribe({
                onSuccess(it)
            },{
                onError(it.localizedMessage)
            })
    }

}