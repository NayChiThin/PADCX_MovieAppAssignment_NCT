package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import kotlinx.android.synthetic.main.viewpod_movie_item.view.*

class MovieItemViewPod @JvmOverloads constructor(
    context:Context,attrs:AttributeSet? = null,defStyleAttr:Int=0
): RelativeLayout(context,attrs,defStyleAttr) {
    private var mDelegate : Delegate? = null
    private var movieId : Int = 0
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }
    fun setUpDelegate(delegate: Delegate) {
        mDelegate = delegate
    }
    fun setUpListener() {
        ivMoviePoster.setOnClickListener {
            mDelegate?.onTapMovieItem(movieId)
        }
    }
    fun setUpData(data:MovieVO) {
        movieId = data.id
        tvMovieTitle.text = data.title
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/original"+data.posterPath)
            .into(ivMoviePoster)
        rbMovieRating.rating = data.voteAverage
    }
    fun removeTopIndicator() {
        tvTop.visibility = View.GONE
    }
    interface Delegate {
        fun onTapMovieItem(movieId:Int)
    }
}