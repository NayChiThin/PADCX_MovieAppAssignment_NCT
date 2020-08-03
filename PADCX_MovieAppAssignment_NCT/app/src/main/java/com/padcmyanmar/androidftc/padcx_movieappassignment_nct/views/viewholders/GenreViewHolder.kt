package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders

import android.view.View
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.GenresVO
import kotlinx.android.synthetic.main.type_items.view.*

class GenreViewHolder(itemView:View):BaseGenreViewHolder(itemView) {
    override fun bindData(data: GenresVO) {
        mData = data
        itemView.tvType.text = data.name
    }
}