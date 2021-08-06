package com.capiter.base.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.capiter.base.data.local.AppDao
import com.capiter.base.data.local.AppDatabase
import com.capiter.base.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class StorageModule(var application: Application) {
    @Provides
    fun providesSharedPreference(): SharedPreferences {
        return application.getSharedPreferences(
            Constants.SHARED_PREFERENCE_NAME,
            Context.MODE_PRIVATE
        )
    }


    @Singleton
    @Provides
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }


    @Singleton
    @Provides
    fun provideAppDao(db: AppDatabase): AppDao {
        return db.dataBaseDAO()
    }
}