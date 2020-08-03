package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.R
import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.PersonVO
import kotlinx.android.synthetic.main.viewpod_person_item.view.*

class PersonItemViewPod @JvmOverloads constructor(
    context:Context,attrs:AttributeSet?=null,defStyleAttr:Int=0
) :RelativeLayout(context,attrs, defStyleAttr){
    private var mDelegate : Delegate? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }
    fun setUpDelegate(delegate:Delegate) {
        mDelegate = delegate
    }

    fun setUpListener() {
        ivPerson.setOnClickListener {
            mDelegate?.onTapPersonItem()
        }
    }
    fun setUpData(data: PersonVO) {
        tvPersonName.text = data.name
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/original"+data.profilePath)
            .into(ivPerson)
    }
    fun setFavouritePerson() {
        ivLike.setImageResource(R.drawable.ic_favorite_yellow_24dp)
    }
    fun setNotFavouritePerson() {
        ivLike.setImageResource(R.drawable.ic_favorite_border_yellow_24dp)
    }

    interface Delegate {
        fun onTapPersonItem()
    }
}