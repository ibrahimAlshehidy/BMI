package com.ibrahim.bmi.personalDetails.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.widget.RelativeLayout
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.ibrahim.bmi.BaseClass
import com.ibrahim.bmi.R
import kotlinx.android.synthetic.main.activity_personal_details.*

@SuppressLint("Registered")
class PersonalDetailsPresenter : BaseClass(), PersonalDetailsViewPresenter {
    override fun initUI(
        context: Context,
        adView: AdView,
        rlRate: RelativeLayout
    ) {
        MobileAds.initialize(context, "ca-app-pub-4532535524937753/1777625457")
        val adRequest =
            AdRequest.Builder().build()
        adView.loadAd(adRequest)
        rlRate.setOnClickListener {
            Toast.makeText(context, context.getString(R.string.addRate), Toast.LENGTH_SHORT)
                .show()
        }

    }

    public override fun onPause() {
        adView.pause()
        super.onPause()
    }

    // Called when returning to the activity
    public override fun onResume() {
        super.onResume()
        adView.resume()
    }

    // Called before the activity is destroyed
    public override fun onDestroy() {
        adView.destroy()
        super.onDestroy()
    }


}
