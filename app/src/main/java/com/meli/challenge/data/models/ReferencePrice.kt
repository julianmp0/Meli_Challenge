package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class ReferencePrice(
    @SerializedName("amount")
    val amount: Float,
    @SerializedName("conditions")
    val conditions: ConditionsX,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("exchange_rate_context")
    val exchangeRateContext: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("tags")
    val tags: List<Any>,
    @SerializedName("type")
    val type: String
)