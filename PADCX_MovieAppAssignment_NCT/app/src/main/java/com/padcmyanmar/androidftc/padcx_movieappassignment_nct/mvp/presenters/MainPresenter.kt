package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.MovieItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.PersonItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.SliderItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>,MovieItemDelegate,PersonItemDelegate,SliderItemDelegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner,genreId:Int)
    fun onTapGenreItems(genreId: Int)
}