package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models.MovieModel
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models.MovieModelImpl
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.MainView

class MainPresenterImpl: MainPresenter,AbstractBasePresenter<MainView>() {
    var mMovieModel : MovieModel = MovieModelImpl
    private lateinit var lifecycleOwner: LifecycleOwner
    override fun onUiReady(lifecycleOwner: LifecycleOwner,genreId:Int) {
        this.lifecycleOwner = lifecycleOwner
        loadAllMoviesFromApi()
        requestPopularMovies(lifecycleOwner)
        requestNowPlayingMovies(lifecycleOwner)
        requestGenres(lifecycleOwner)
        requestPersonList(lifecycleOwner)
        requestMoviesByGenre(lifecycleOwner,genreId)
        requestUpcomingMovies(lifecycleOwner)
    }

    override fun onTapGenreItems(genreId: Int) {
        requestMoviesByGenre(lifecycleOwner,genreId)
    }

    override fun onTapMovieItem(movieId: Int) {
        mView?.navigateToDetails(movieId)
    }

    override fun onTapPersonItem() {

    }

    override fun onTapPlay(movieId: Int) {
        mMovieModel.getMovieVideosById(movieId,
            onSuccess = {
                mView?.navigateToPlay(it)
            },
            onError = {})
    }

    private fun loadAllMoviesFromApi() {
        mMovieModel.getAllMoviesFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )
    }
    private fun requestPopularMovies(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getPopularMovies(
            onError = {}
        ).observe(lifecycleOwner, Observer {
            mView?.displayPopularMovieList(it)
        })
    }
    private fun requestNowPlayingMovies(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getNowPlayingMovies(
            onError = {}
        ).observe(lifecycleOwner, Observer {
            mView?.displayNowPlayingMovieList(it)
        })
    }
    private fun requestUpcomingMovies(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getUpcomingMovies(
            onError = {}
        ).observe(lifecycleOwner, Observer {
            mView?.displayUpcomingMovieList(it)
        })
    }
    private fun requestGenres(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getGenres(
            onError = {}
        ).observe(lifecycleOwner, Observer {
            mView?.setGenresList(it)
        })
    }
    private fun requestPersonList(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getPersonList(
            onError = {}
        ).observe(lifecycleOwner, Observer {
            mView?.displayPersonList(it)
        })
    }
    private fun requestMoviesByGenre(lifecycleOwner: LifecycleOwner,genreId: Int) {
        mMovieModel.getMoviesByGenre(genreId)
            .observe(lifecycleOwner, Observer {
                val moviesByGenre = it.filter { movie ->
                    movie.genreIds.contains(genreId)
                }
                    .toList()
                mView?.displayMoviesByGenre(moviesByGenre)
            })
    }
}