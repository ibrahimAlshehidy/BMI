package com.ibrahim.bmi.addDetails.presenter

import android.content.Context
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView

interface AddDetailsViewPresenter {
    fun addDetails(
        context: Context?,
        etUserName: EditText,
        npWeight: NumberPicker,
        npHeight: NumberPicker,
        npGender: NumberPicker,
        tvCalculate: TextView
    )

}