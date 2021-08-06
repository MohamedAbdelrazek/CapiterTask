package com.capiter.base.data.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProductItem(
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("image-url")
    val imageUrl: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("cartCount")
    val cartCount: Int? = 0,
    @SerializedName("price")
    val price: String? = null
) : Parcelable


@BindingAdapter("android:src")
fun ImageView.setImageUrl(url: String?) {
    Glide.with(this.context).load(url).into(this)
}