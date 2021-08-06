package com.capiter.base.data.network

import com.capiter.base.data.model.UserRecord
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiClient {

    @GET("api-stores/cities")
    fun getAllCities(@Header("lang") lang: String): Flowable<UserRecord>
}