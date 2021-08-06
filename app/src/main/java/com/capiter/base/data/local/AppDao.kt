package com.capiter.base.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.capiter.base.data.model.ProductItem
import io.reactivex.rxjava3.core.Completable


@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productItem: ProductItem): Completable
}