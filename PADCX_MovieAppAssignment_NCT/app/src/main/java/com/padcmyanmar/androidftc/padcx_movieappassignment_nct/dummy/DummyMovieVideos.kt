package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoDetailVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.VideoVO

fun getDummyVideos() : List<VideoDetailVO> {
    val videoOne = VideoDetailVO()
    videoOne.id = 550
    videoOne.results.add(VideoVO("5c9294240e0a267cd516835f","BdJKm16Co6M"))
    videoOne.results.add(VideoVO("5e382d1b4ca676001453826d","6JnN1DmbqoU"))
    val videoTwo = VideoDetailVO()
    videoTwo.id = 2
    videoTwo.results.add(VideoVO("5c9294240e0a267cd516835f","BdJKm16Co6M"))
    return arrayListOf(videoOne,videoTwo)
}