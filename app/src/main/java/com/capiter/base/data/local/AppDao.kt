package com.capiter.base.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.capiter.base.data.model.ProductItem
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable


@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productItem: ProductItem): Completable

    @Query("SELECT * FROM PRODUCT_TABLE")
    fun getCartProduct(): Flowable<List<ProductItem?>?>?


    @Query("DELETE FROM PRODUCT_TABLE WHERE id = :itemID")
    fun deleteItemFromCart(itemID: String) : Completable


    @Query("SELECT * FROM PRODUCT_TABLE WHERE id=:id ")
    fun getCartItem(id: String): Flowable<ProductItem>
}