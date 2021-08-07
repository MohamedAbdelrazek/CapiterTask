package com.capiter.base.data.model


import com.google.gson.annotations.SerializedName

data class OrderItem(
    @SerializedName("order-name")
    val orderName: String? = null,
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("product-id")
    val productId: String? = null,
    @SerializedName("product-image-url")
    val productImageUrl: String? = null,
    @SerializedName("product-name")
    val productName: String? = null,
    @SerializedName("product-price")
    val productPrice: String? = null,
    @SerializedName("product-quantity")
    val productQuantity: Int? = null
)