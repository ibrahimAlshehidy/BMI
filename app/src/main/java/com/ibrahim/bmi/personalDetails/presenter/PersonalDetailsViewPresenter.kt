package com.ibrahim.bmi.personalDetails.presenter

import android.content.Context
import android.widget.RelativeLayout
import com.google.android.gms.ads.AdView

interface PersonalDetailsViewPresenter {
    fun initUI(
        context: Context,
        adView: AdView,
        rlRate: RelativeLayout
    )
}