package com.krisna_18102271.ligartani.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.krisna_18102271.ligartani.R

class OnboardingAdapter(val context: Context):PagerAdapter() {
    val imgArray: IntArray = intArrayOf(R.drawable.ob1, R.drawable.ob2, R.drawable.ob3)
    val titleArray: Array<String> = arrayOf("Siap Untuk Menanam?", "Tutorial yang Bervariatif", "Bersiaplah Menanam!!!")
    val descArray: Array<String> = arrayOf(" ", "Dengan tutorial yang variatif anda dapat memilih tutorial sesuai keinginan anda", "Mari mulai menanam!")
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imgArray.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.slide_onboarding, container, false)
        val img: ImageView = view.findViewById(R.id.iv_img)
        val txtTitle: TextView = view.findViewById(R.id.tv_title)
        val txtDesc: TextView = view.findViewById(R.id.tv_desc)

        img.setImageDrawable(ContextCompat.getDrawable(context, imgArray[position]))
        txtTitle.text = titleArray[position]
        txtDesc.text = descArray[position]
        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view: View = `object` as View
        container.removeView(view)
    }
}