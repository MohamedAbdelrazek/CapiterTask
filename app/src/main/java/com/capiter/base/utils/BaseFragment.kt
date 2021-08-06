package com.capiter.base.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.capiter.base.di.AppComponent

open class BaseFragment : Fragment() {
    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent = (context?.applicationContext as MyApplication).appComponent
    }

}