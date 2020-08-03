package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders

import android.view.View
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.MovieItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewpods.MovieItemViewPod
import kotlinx.android.synthetic.main.movie_items.view.*

class PopularMovieViewHolder(itemView:View,private val delegate:MovieItemDelegate):
        BasePopularMovieViewHolder(itemView) {

    private val mMovieItemViewPod = itemView.viewpodMovieItem as MovieItemViewPod
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapMovieItem(it.id)
            }
        }
    }
    override fun bindData(data: MovieVO) {
        mData = data

        mMovieItemViewPod.setUpData(data)
        mMovieItemViewPod.setUpDelegate(delegate)
    }

}