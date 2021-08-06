package com.capiter.base.data.repo

import android.content.SharedPreferences
import com.capiter.base.data.model.UserRecord
import com.capiter.base.data.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class UserRepo @Inject constructor(
    private var apiClient: ApiClient,
    private var sharedPref: SharedPreferences
) {

    fun getAllCities(): Flowable<UserRecord> =
        apiClient.getAllCities("en").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun puString(key: String, value: String) {
        sharedPref.edit().putString(key, value).apply()
    }
}