package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoDetailVO

interface VideoPlayView : BaseView {
    fun displayVideo(video:VideoDetailVO)
}