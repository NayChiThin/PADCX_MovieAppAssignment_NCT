package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders

import android.view.View
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.PersonVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.PersonItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewpods.PersonItemViewPod
import kotlinx.android.synthetic.main.person_items.view.*

class PersonViewHolder(itemView:View,private val delegate:PersonItemDelegate):BasePersonViewHolder(itemView) {
    private val mPersonItemViewPod = itemView.viewpodPersonItem as PersonItemViewPod
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapPersonItem()
            }
        }
    }
    override fun bindData(data: PersonVO) {
        mData = data
        mPersonItemViewPod.setUpData(data)
        mPersonItemViewPod.setUpDelegate(delegate)
    }
}