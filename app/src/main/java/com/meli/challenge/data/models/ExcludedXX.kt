package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class ExcludedXX(
    @SerializedName("real_rate")
    val realRate: Double,
    @SerializedName("real_value")
    val realValue: Int
)