package com.ibrahim.bmi.splash.presenter

import android.content.Context
import android.content.Intent
import android.os.Handler
import com.ibrahim.bmi.addDetails.view.AddDetailsActivity

class SplashPresenter : SplashViewPresenter {


    override fun go(context: Context?) {
        Handler().postDelayed({
            val intent = Intent(context, AddDetailsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            context?.startActivity(intent)
        }, 3000)

    }
}