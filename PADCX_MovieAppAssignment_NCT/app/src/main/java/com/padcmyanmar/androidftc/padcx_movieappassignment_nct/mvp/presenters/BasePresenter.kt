package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view:T)
}