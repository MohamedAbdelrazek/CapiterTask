package com.capiter.base.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.capiter.base.utils.Constants
import dagger.Module
import dagger.Provides


@Module
class StorageModule(var application: Application) {
    @Provides
    fun providesSharedPreference(): SharedPreferences {
        return application.getSharedPreferences(
            Constants.SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE
            )
    }
}