package com.krisna_18102271.ligartani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tutorial_detail.*

class TutorialDetailActivity : AppCompatActivity() {

    var x : Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_detail)

        initView()
    }

    fun initView() {
        x = intent.extras

        tv_strw.text = x?.getString("title")
        tv_descstrw.text = x?.getString("description")
    }
}