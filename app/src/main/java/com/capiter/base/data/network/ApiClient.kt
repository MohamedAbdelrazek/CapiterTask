package com.capiter.base.data.network

import com.capiter.base.data.model.ProductItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiClient {

    @GET("products")
    fun getProducts(
        @Header("x-apikey") xApiToken: String = "87c35db9718530498e6f8be2514da8cf5989a",
        @Query("page") page: Int = 1
    ): Single<ArrayList<ProductItem>>
}