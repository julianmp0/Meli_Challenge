package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class Seller(
    @SerializedName("car_dealer")
    val carDealer: Boolean,
    @SerializedName("eshop")
    val eshop: Eshop,
    @SerializedName("id")
    val id: Int,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("real_estate_agency")
    val realEstateAgency: Boolean,
    @SerializedName("registration_date")
    val registrationDate: String,
    @SerializedName("seller_reputation")
    val sellerReputation: SellerReputation,
    @SerializedName("tags")
    val tags: List<String>
)