package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class Excluded(
    @SerializedName("real_rate")
    val realRate: Int,
    @SerializedName("real_value")
    val realValue: Int
)