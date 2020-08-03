package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.views.components

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.tabs.TabLayout
import java.lang.reflect.Field


class CustomTabLayout : TabLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        try {
            if (tabCount == 0) return
            val field: Field = TabLayout::class.java.getDeclaredField("tabMinWidth")
            field.setAccessible(true)
            field.set(this, (measuredWidth / tabCount.toFloat()).toInt())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}