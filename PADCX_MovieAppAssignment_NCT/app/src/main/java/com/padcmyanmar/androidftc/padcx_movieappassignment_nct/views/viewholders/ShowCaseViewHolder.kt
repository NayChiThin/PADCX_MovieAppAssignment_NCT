package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.SliderItemDelegate
import kotlinx.android.synthetic.main.showcase_items.view.*

class ShowCaseViewHolder(itemView:View,private val delegate:SliderItemDelegate): BaseShowCaseViewHolder(itemView) {
    init {
        itemView.btnPlay.setOnClickListener {
            mData?.id?.let { it1 -> delegate.onTapPlay(it1) }
        }
    }
    override fun bindData(data: MovieVO) {
        mData = data
        itemView.tvShowCaseTitle.text = data.title
        itemView.tvShowCaseDate.text = data.releaseDate
        Glide.with(itemView.context)
            .load("https://image.tmdb.org/t/p/original"+data.posterPath)
            .into(itemView.ivShowCase)
    }
}