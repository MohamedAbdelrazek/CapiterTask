package com.capiter.base.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserRecord (
    @SerializedName("Id")
    @Expose
    val id: Long? = null,

    @SerializedName("Name")
    @Expose
    private val name: String? = null,

    @SerializedName("Email")
    @Expose
    private val email: String? = null,

    @SerializedName("Password")
    @Expose
    private val password: String? = null,

    @SerializedName("MobileNumber")
    @Expose
    private val mobileNumber: String? = null,

    @SerializedName("Token")
    @Expose
    private val token: String? = null,

    @SerializedName("ImageUrl")
    @Expose
    private val imageUrl: String? = null

) : Parcelable
