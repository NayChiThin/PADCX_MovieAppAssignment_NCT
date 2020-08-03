package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.models.MovieModelImpl
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.MainView
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.VideoPlayView

class VideoPlayPresenterImpl : VideoPlayPresenter,AbstractBasePresenter<VideoPlayView>() {
    private val mMovieModel = MovieModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int) {
        requestMovieVideoById(lifecycleOwner,movieId)
    }

    private fun requestMovieVideoById(lifecycleOwner: LifecycleOwner,movieId: Int) {
        mMovieModel.getMovieVideosById(movieId,onSuccess = {
            mView?.displayVideo(it)
        },onError = {})
    }
}