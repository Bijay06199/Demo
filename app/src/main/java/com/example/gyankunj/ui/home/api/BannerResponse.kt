package com.example.gyankunj.ui.home.api


import com.google.gson.annotations.SerializedName

data class BannerResponse(
    @SerializedName("success")
    val success: Int? = 0,
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("data")
    val `data`: BannerData? = null,
    @SerializedName("response")
    val response: Int? = 0

)

data class BannerData(
    @SerializedName("rows")
    val rows: List<BannerRow?>?=null,
    @SerializedName("count")
    val count: Int?=0
)

data class BannerRow(
    @SerializedName("name")
    val name: String?="",
    @SerializedName("image")
    val image: String?="",
    @SerializedName("is_archived")
    val isArchived: Boolean?=false,
    @SerializedName("_id")
    val id: String?="",
    @SerializedName("createdAt")
    val createdAt: String?="",
    @SerializedName("__v")
    val v: Int?=0
)

