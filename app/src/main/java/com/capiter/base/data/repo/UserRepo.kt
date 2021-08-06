package com.capiter.base.data.repo

import android.content.SharedPreferences
import com.capiter.base.data.model.ProductItem
import com.capiter.base.data.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class UserRepo @Inject constructor(
    private var apiClient: ApiClient,
    private var sharedPref: SharedPreferences
) {

    fun getProducts(): Single<ArrayList<ProductItem>> =
        apiClient.getProducts().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


}