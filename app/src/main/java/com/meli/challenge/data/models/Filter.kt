package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("values")
    val values: List<ValueX>
)