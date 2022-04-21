package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class ExcludedX(
    @SerializedName("real_rate")
    val realRate: Float,
    @SerializedName("real_value")
    val realValue: Float
)