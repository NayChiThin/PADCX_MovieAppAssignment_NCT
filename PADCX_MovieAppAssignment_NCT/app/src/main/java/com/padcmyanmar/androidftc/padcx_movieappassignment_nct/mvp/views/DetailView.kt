package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.mvp.views

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.PersonVO

interface DetailView:BaseView {
    fun displayActorList(actorList:List<PersonVO>)
    fun displalyCreatorList(creatorList:List<PersonVO>)
    fun displayMovieDetails(movie:MovieVO)
    fun navigateToMainScreen()
}