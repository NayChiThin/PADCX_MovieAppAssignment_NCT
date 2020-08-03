package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.MainView
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.VideoPlayView

interface VideoPlayPresenter : BasePresenter<VideoPlayView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner,movieId:Int)
}