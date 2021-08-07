package com.capiter.base.utils

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capiter.base.di.AppComponent


open class BaseActivity : AppCompatActivity() {
    lateinit var appComponent: AppComponent
    lateinit var mProgress: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent = (application as MyApplication).appComponent

        mProgress = ProgressDialog(this)
        mProgress.setTitle("يرجي الانتظار")
        mProgress.setMessage("جاري ارسال الطلب")
        mProgress.setCancelable(false) // disable di

    }
}