package com.ibrahim.bmi.splash.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ibrahim.bmi.R


class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_details)
        initUI()

    }

    private fun initUI() {
//        val data =
//            arrayOf("Berlin", "Moscow", "Tokyo", "Paris")
//        npHeight.minValue = 0
//        npHeight.maxValue = data.size - 1
//        npHeight.displayedValues = data
    }
}
