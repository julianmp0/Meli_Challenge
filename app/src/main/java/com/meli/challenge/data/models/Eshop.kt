package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class Eshop(
    @SerializedName("eshop_experience")
    val eshopExperience: Int,
    @SerializedName("eshop_id")
    val eshopId: Int,
    @SerializedName("eshop_locations")
    val eshopLocations: List<Any>,
    @SerializedName("eshop_logo_url")
    val eshopLogoUrl: String,
    @SerializedName("eshop_rubro")
    val eshopRubro: Any,
    @SerializedName("eshop_status_id")
    val eshopStatusId: Int,
    @SerializedName("nick_name")
    val nickName: String,
    @SerializedName("seller")
    val seller: Int,
    @SerializedName("site_id")
    val siteId: String
)