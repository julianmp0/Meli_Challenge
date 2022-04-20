package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class SellerReputation(
    @SerializedName("level_id")
    val levelId: String,
    @SerializedName("metrics")
    val metrics: Metrics,
    @SerializedName("power_seller_status")
    val powerSellerStatus: Any,
    @SerializedName("protection_end_date")
    val protectionEndDate: String,
    @SerializedName("real_level")
    val realLevel: String,
    @SerializedName("transactions")
    val transactions: Transactions
)