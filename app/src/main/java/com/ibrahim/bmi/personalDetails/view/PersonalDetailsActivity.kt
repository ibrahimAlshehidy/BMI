package com.ibrahim.bmi.personalDetails.view

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.text.format.DateFormat
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ibrahim.bmi.R
import com.ibrahim.bmi.personalDetails.presenter.PersonalDetailsPresenter
import kotlinx.android.synthetic.main.activity_add_details.ivBack
import kotlinx.android.synthetic.main.activity_personal_details.*
import java.io.File
import java.io.FileOutputStream
import java.util.*


class PersonalDetailsActivity : AppCompatActivity() {


    private var personalDetailsPresenter: PersonalDetailsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_details)
        tvBMIPercentage.text = intent.getStringExtra("BMI")
        tvDescription.text = intent.getStringExtra("description")
        tvPonderalIndex.text = intent.getStringExtra("piDetails")
        personalDetailsPresenter = PersonalDetailsPresenter()
        personalDetailsPresenter?.initUI(
            this,
            adView,
            rlRate
        )
        initUI()
    }

    private fun initUI() {
        ivBack.setOnClickListener {
            finish()
        }
        rlShare.setOnClickListener {
            takeScreenshot()
        }
    }


    private fun takeScreenshot() {
        val now = Date()
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", now)
        try { // image naming and path  to include sd card  appending name you choose for file
            val mPath: String =
                Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg"
            // create bitmap screen capture
            val v1: View = window.decorView.rootView
            v1.isDrawingCacheEnabled = true
            val bitmap: Bitmap = Bitmap.createBitmap(v1.drawingCache)
            v1.isDrawingCacheEnabled = false
            val imageFile = File(mPath)
            val outputStream = FileOutputStream(imageFile)
            val quality = 100
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
            outputStream.flush()
            outputStream.close()
            Toast.makeText(this, getString(R.string.screenShotTaken), Toast.LENGTH_SHORT).show()
        } catch (e: Throwable) { // Several error may come out with file handling or DOM
            e.printStackTrace()
            Log.e("caa", e.toString())
        }
    }
}
