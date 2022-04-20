package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class ValueX(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("path_from_root")
    val pathFromRoot: List<PathFromRoot>
)