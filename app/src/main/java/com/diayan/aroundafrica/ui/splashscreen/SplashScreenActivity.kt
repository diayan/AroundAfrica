package com.diayan.aroundafrica.ui.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diayan.aroundafrica.R
import com.diayan.aroundafrica.ui.onboarding.OnBoardingActivity
import com.diayan.aroundafrica.util.IntentUtil

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        init()
    }

    private fun init() {
        IntentUtil.start(this, OnBoardingActivity::class.java)
        finish()
    }
}
