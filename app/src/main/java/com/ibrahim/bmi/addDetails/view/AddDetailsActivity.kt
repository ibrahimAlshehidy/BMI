package com.ibrahim.bmi.addDetails.view


import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.ibrahim.bmi.R
import com.ibrahim.bmi.addDetails.presenter.AddDetailsPresenter
import kotlinx.android.synthetic.main.activity_add_details.*


class AddDetailsActivity : AppCompatActivity() {
    private var addDetailsPresenter: AddDetailsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_details)
        addDetailsPresenter = AddDetailsPresenter()
        addDetailsPresenter?.addDetails(
            this,
            etUserName,
            npWeight,
            npHeight,
            npGender,
            tvCalculate
        )
        isStoragePermissionGranted()
        initUi()
    }

    fun isStoragePermissionGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED
            ) {
                Log.v("permisson", "Permission is granted")
                true
            } else {
                Log.v("permisson", "Permission is revoked")
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )
                false
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("permisson", "Permission is granted")
            true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v(
                "permisson_taken",
                "Permission: " + permissions[0] + "was " + grantResults[0]
            )
            //resume tasks needing this permission
        }
    }

    private fun initUi() {
        ivBack.setOnClickListener {
            finish()
        }
    }

}
