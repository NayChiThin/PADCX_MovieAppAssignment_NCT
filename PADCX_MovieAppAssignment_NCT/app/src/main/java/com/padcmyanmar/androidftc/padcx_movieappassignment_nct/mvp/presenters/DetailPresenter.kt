package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.PersonItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.DetailView

interface DetailPresenter:BasePresenter<DetailView>,PersonItemDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner,movieId:Int)
    fun onTapBack()
}