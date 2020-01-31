package com.ibrahim.bmi.addDetails.presenter

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener
import android.widget.TextView
import com.ibrahim.bmi.personalDetails.view.PersonalDetailsActivity
import java.util.*
import kotlin.math.roundToInt

class AddDetailsPresenter : AddDetailsViewPresenter {
    var userName: String = ""
    var description: String = ""
    var piDetails: String = ""
    var weight: Double = 1.0
    var height: Double = 1.0
    var heightPI: Double = 1.0
    var bmi: Double = 1.0
    var pi: Double = 1.0
    override fun addDetails(
        context: Context?,
        etUserName: EditText,
        npWeight: NumberPicker,
        npHeight: NumberPicker,
        npGender: NumberPicker,
        tvCalculate: TextView

    ) {
        val data3: MutableList<Int> = ArrayList()
        for (i in 1000..2999) data3.add(i)

//////////////Gender///////////////////

        val data =
            arrayOf("Male", "Female")
        npGender.minValue = 0
        npGender.maxValue = data.size - 1
        npGender.displayedValues = data

//////////////////Height////////////////////

        npHeight.minValue = 1
        npHeight.maxValue = 3000
        npHeight.setOnValueChangedListener(OnValueChangeListener { _, _, newVal ->
            //Process the changes here
            npHeight.value = newVal
            height = (npHeight.value.toDouble() / 100) * (npHeight.value.toDouble() / 100)
            heightPI =
                (npHeight.value.toDouble() / 100) * (npHeight.value.toDouble() / 100) * (npHeight.value.toDouble() / 100)
        })

////////////////////////Weight////////////////////

        npWeight.minValue = 1
        npWeight.maxValue = 3000
        npWeight.setOnValueChangedListener(OnValueChangeListener { _, _, newVal ->
            //Process the changes here
            npWeight.value = newVal
            weight = npWeight.value.toDouble()
        })

//////////////////////calculating BMI ///////////////

        fun calculate() {
            userName = etUserName.text.toString()
            bmi = ((weight / height) * 100).roundToInt().toDouble()
            bmi /= 100
            pi = ((weight / heightPI) * 100).roundToInt().toDouble()
            pi /= 100
            when {
                bmi < 18.5 -> {
                    description = "Hello $userName, you're underweight."
                }
                bmi >= 25 -> {
                    description = "Hello $userName, you're overweight."
                }
                bmi >= 18.5 -> {
                    description = "Hello $userName, you're normal."

                }
            }
            piDetails = "Ponderal index: $pi kg/m3"

        }

        tvCalculate.setOnClickListener {
            calculate()
            var cancel = false
            var focusView: View? = null
            if (TextUtils.isEmpty(etUserName.text.toString())) {
                etUserName.error = "Please, enter your name."
                focusView = etUserName
                cancel = true
            }
            if (cancel) { // There was an error; don't attempt login and focus the first
                focusView!!.requestFocus()
            } else {

                val intent = Intent(context, PersonalDetailsActivity::class.java)
                intent.putExtra("description", description)
                intent.putExtra("BMI", bmi.toString())
                intent.putExtra("piDetails", piDetails)
                context?.startActivity(intent)
            }
        }


    }
}