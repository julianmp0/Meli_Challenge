package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class ValueXX(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("source")
    val source: Long,
    @SerializedName("struct")
    val struct: Any
)