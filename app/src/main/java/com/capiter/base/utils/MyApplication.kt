package com.capiter.base.utils

import android.app.Application
import com.capiter.base.di.AppComponent
import com.capiter.base.di.DaggerAppComponent
import com.capiter.base.di.NetworkModule
import com.capiter.base.di.StorageModule


class MyApplication : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule(this)).storageModule(StorageModule(this))
            .build()

    }
}