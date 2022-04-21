package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class Sort(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)