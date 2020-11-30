package com.krisna_18102271.ligartani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.krisna_18102271.ligartani.adapter.OnboardingAdapter
import com.krisna_18102271.ligartani.util.SharedPreferences
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    lateinit var wkAdapter: OnboardingAdapter
    val dots = arrayOfNulls<TextView>(3)
    var currentpage: Int = 0
    lateinit var pre: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        pre = SharedPreferences(this)
        wkAdapter = OnboardingAdapter(this)
        vp_onboarding.adapter = wkAdapter
        dotIndicator(currentpage)
        initAction()
    }

    fun initAction(){
        vp_onboarding.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                dotIndicator(position)
                currentpage = position
            }

        })

        tv_next.setOnClickListener {
            if (vp_onboarding.currentItem + 1 < dots.size) {
            vp_onboarding.currentItem += 1
            } else {
                pre.stInst = true
                val intent = Intent (this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        tv_skip.setOnClickListener {
            pre.stInst = true
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun dotIndicator(p: Int) {
        ll_dots.removeAllViews()

        for (i in 0..dots.size-1){
            dots[i] = TextView(this)
            dots[i]?.textSize = 35f
            dots[i]?.setTextColor(resources.getColor(R.color.gray))
            dots[i]?.text = Html.fromHtml("&#x2022;")

            ll_dots.addView(dots[i])
        }
        if (dots.size>0){
            dots[p]?.setTextColor(resources.getColor(R.color.ColorPrimary))
        }
    }
}