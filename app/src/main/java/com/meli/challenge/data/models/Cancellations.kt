package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class Cancellations(
    @SerializedName("excluded")
    val excluded: Excluded,
    @SerializedName("period")
    val period: String,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("value")
    val value: Int
)