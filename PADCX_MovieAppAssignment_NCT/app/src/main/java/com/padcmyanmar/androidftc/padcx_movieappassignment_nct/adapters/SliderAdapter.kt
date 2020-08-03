package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.MovieVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.SliderItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.SliderViewHolder
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapter(delegate: SliderItemDelegate) : SliderViewAdapter<SliderViewHolder>() {

    var mData : MutableList<MovieVO> = arrayListOf()
    val mDelegate : SliderItemDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_items,parent,false)
        return SliderViewHolder(
            view,
            mDelegate
        )
    }

    override fun getCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder, position: Int) {
        viewHolder.bindData(mData[position])
    }
    fun setNewData(data:MutableList<MovieVO>) {
        mData = data
        notifyDataSetChanged()
    }
}
