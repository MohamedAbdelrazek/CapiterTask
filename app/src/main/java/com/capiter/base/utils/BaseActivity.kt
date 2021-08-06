package com.capiter.base.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capiter.base.di.AppComponent

open class BaseActivity : AppCompatActivity() {
    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent = (application as MyApplication).appComponent
    }
}