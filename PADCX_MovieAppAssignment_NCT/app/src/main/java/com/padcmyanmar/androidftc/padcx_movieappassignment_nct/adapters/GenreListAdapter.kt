package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.GenresVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.BaseGenreViewHolder
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.GenreViewHolder

class GenreListAdapter:BaseRecyclerAdapter<BaseGenreViewHolder,GenresVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseGenreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.type_items,parent,false)
        return GenreViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: BaseGenreViewHolder, position: Int) {
        holder.bindData(mData[position])
    }

}