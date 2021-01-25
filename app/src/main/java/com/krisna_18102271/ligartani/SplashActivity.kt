package com.krisna_18102271.ligartani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.krisna_18102271.ligartani.util.SharedPreferences

class SplashActivity : AppCompatActivity() {
    lateinit var pre: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        pre = SharedPreferences(this)

        Handler().postDelayed({
            var i = Intent()

            if (!pre.stInst){
                i = Intent( this, OnboardingActivity::class.java)
            }else{
                i = Intent( this, MainActivity::class.java)
            }

            startActivity(i)
            finish()
        }, 3000)
    }
}