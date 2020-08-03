package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.PersonVO
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.delegates.PersonItemDelegate
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.BasePersonViewHolder
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewholders.PersonViewHolder

class PersonListAdapter(delegate:PersonItemDelegate):BaseRecyclerAdapter<BasePersonViewHolder,PersonVO>() {
    val mDelegate : PersonItemDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasePersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_items,parent,false)
        return PersonViewHolder(
            view,
            mDelegate
        )
    }

    override fun onBindViewHolder(holder: BasePersonViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}