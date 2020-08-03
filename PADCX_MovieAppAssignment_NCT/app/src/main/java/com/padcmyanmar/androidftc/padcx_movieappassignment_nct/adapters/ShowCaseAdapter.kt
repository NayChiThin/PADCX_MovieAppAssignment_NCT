package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.SliderItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.BaseShowCaseViewHolder
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.ShowCaseViewHolder

class ShowCaseAdapter(delegate:SliderItemDelegate) : BaseRecyclerAdapter<BaseShowCaseViewHolder,MovieVO>() {
    val mDelegate: SliderItemDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseShowCaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.showcase_items,parent,false)
        return ShowCaseViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: BaseShowCaseViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}