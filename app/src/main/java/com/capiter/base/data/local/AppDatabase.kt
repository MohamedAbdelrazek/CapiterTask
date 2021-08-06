package com.capiter.base.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.capiter.base.data.model.ProductItem

@Database(entities = [ProductItem::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataBaseDAO(): AppDao
}