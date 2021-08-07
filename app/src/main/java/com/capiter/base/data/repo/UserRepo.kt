package com.capiter.base.data.repo

import android.content.SharedPreferences
import com.capiter.base.data.local.AppDao
import com.capiter.base.data.model.ProductItem
import com.capiter.base.data.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class UserRepo @Inject constructor(
    var apiClient: ApiClient,
    var sharedPref: SharedPreferences,
    var appDao: AppDao
) {

    fun getProducts(): Single<ArrayList<ProductItem>> =
        apiClient.getProducts().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    fun insertNewProduct(item: ProductItem) =appDao.insertProduct(item)

    fun getCartProduct() = appDao.getCartProduct()

    fun removeItemFromCart(itemID: String) = appDao.deleteItemFromCart(itemID)


    fun getCartItem(id:String) = appDao.getCartItem(id)
}


