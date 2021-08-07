package com.capiter.base.data.network

import com.capiter.base.data.model.OrderItem
import com.capiter.base.data.model.ProductItem
import com.capiter.base.utils.Constants
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface ApiClient {

    @GET("products")
    fun getProducts(
        @Header("x-apikey") xApiToken: String = Constants.xApiToken,
        @Query("page") page: Int = 1
    ): Single<ArrayList<ProductItem>>


    @POST("orders")
    fun sendOrders(
        @Header("x-apikey") xApiToken: String = Constants.xApiToken,
        @Body orderList: List<OrderItem>
    ): Flowable<ArrayList<ProductItem>>


    @GET("orders")
    fun getOrders(
        @Header("x-apikey") xApiToken: String = Constants.xApiToken,
    ): Single<ArrayList<OrderItem>>

}