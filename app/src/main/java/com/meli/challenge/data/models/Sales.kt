package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class Sales(
    @SerializedName("completed")
    val completed: Int,
    @SerializedName("period")
    val period: String
)