package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models.MovieModel
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models.MovieModelImpl
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter,AbstractBasePresenter<DetailView>() {
    var mMovieModel : MovieModel = MovieModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int) {
        requestActorList(lifecycleOwner)
        movieId.let {
            mMovieModel.getMovieById(it)
                .observe(lifecycleOwner, Observer {
                    mView?.displayMovieDetails(it)
                })
        }
    }

    override fun onTapBack() {
        mView?.navigateToMainScreen()
    }

    override fun onTapPersonItem() {

    }
    private fun requestActorList(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getPersonList(
            onError = {}
        ).observe(lifecycleOwner, Observer {
            mView?.displayActorList(it)
            mView?.displalyCreatorList(it)
        })
    }
}