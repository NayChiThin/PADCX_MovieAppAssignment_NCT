package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.SliderItemDelegate
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.slider_items.view.*

class SliderViewHolder(itemView:View,private val delegate:SliderItemDelegate) : SliderViewAdapter.ViewHolder(itemView) {
    var mData : MovieVO? = null
init {
    itemView.btnPlay.setOnClickListener {
        mData?.id?.let { it1 -> delegate.onTapPlay(it1) }
    }
}
    fun bindData(movie:MovieVO) {
        mData = movie
        itemView.tvSliderTitle.text = movie.title
        Glide.with(itemView.context)
            .load("https://image.tmdb.org/t/p/original"+movie.posterPath)
            .into(itemView.ivSliderImage)
    }
}
