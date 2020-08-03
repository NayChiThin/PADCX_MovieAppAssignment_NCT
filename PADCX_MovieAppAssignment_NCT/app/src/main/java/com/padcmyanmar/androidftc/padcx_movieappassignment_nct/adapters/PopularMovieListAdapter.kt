package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.MovieItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.BasePopularMovieViewHolder
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.PopularMovieViewHolder

class PopularMovieListAdapter(delegate: MovieItemDelegate):BaseRecyclerAdapter<BasePopularMovieViewHolder,MovieVO>() {
    val mDelegate : MovieItemDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasePopularMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_items,parent,false)
        return PopularMovieViewHolder(
            view,
            mDelegate
        )
    }
    override fun onBindViewHolder(holder: BasePopularMovieViewHolder, position: Int) {
        holder.bindData(mData[position])
    }

}