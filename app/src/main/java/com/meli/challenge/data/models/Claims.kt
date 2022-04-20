package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class Claims(
    @SerializedName("excluded")
    val excluded: ExcludedX,
    @SerializedName("period")
    val period: String,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("value")
    val value: Int
)