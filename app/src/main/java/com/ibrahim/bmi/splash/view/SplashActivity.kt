package com.ibrahim.bmi.splash.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ibrahim.bmi.R
import com.ibrahim.bmi.splash.presenter.SplashPresenter


class SplashActivity : AppCompatActivity() {
    var splashPresenter: SplashPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashPresenter = SplashPresenter()
        splashPresenter?.go(this)

    }
}
